package tk.maincraft.util.mcpackets.serialization;

import static tk.maincraft.util.mcpackets.serialization.SerializationHelper.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ListIterator;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.packet.impl.AbstractPacket;

/**
 * <b>Only {@link AbstractPacket} should extend this!</b>
 */
public abstract class HashcodeAndEqualsStub {
    @Override
    public int hashCode() {
        try {
            final int prime = 31;
            int result = 1;
            List<SerializationInfo> serInfo = getSerializationInfos(getPacketInterface(
                    this.getClass().asSubclass(Packet.class)));
            ListIterator<SerializationInfo> iterator = serInfo.listIterator();
            while (iterator.hasNext()) {
                SerializationInfo info = iterator.next();
                Field field = this.getClass().getDeclaredField(info.getName());
                field.setAccessible(true);
                Object val = field.get(this);
                field.setAccessible(false);
                result = prime * result + ((val == null) ? 0 : val.hashCode());
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        try {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getPacketInterface(getClass().asSubclass(Packet.class))
                    != getPacketInterface(obj.getClass().asSubclass(Packet.class)))
                return false;

            List<SerializationInfo> serInfo = getSerializationInfos(getPacketInterface(
                    this.getClass().asSubclass(Packet.class)));
            ListIterator<SerializationInfo> iterator = serInfo.listIterator();
            while (iterator.hasNext()) {
                SerializationInfo info = iterator.next();
                Field field = this.getClass().getDeclaredField(info.getName());
                field.setAccessible(true);
                Object ourVal = field.get(this);
                field.setAccessible(false);

                // now use the getter to get their val
                Method getter = getPacketInterface(this.getClass().asSubclass(Packet.class))
                        .getMethod(toMethodName(info.getName()));
                Object theirVal = getter.invoke(obj);
                if (!ourVal.equals(theirVal))
                    return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
