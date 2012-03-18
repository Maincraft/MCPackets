package tk.maincraft.util.mcpackets.serialization;

import static tk.maincraft.util.mcpackets.serialization.SerializationHelper.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ListIterator;

import tk.maincraft.util.mcpackets.Packet;

/**
 * <b>Only {@code AbstractPacket} should extend this!</b>
 */
public abstract class HashcodeAndEqualsStub {
    private final Class<? extends Packet> packetType =
            getPacketInterface(this.getClass().asSubclass(Packet.class));
    protected Class<? extends Packet> getInterface() {
        return packetType;
    }

    @Override
    public int hashCode() {
        try {
            final int prime = 31;
            int result = 1;
            List<SerializationInfo> serInfo = getSerializationInfos(packetType);
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
            if (packetType != ((Packet) obj).getPacketType())
                return false;

            List<SerializationInfo> serInfo = getSerializationInfos(packetType);
            ListIterator<SerializationInfo> iterator = serInfo.listIterator();
            while (iterator.hasNext()) {
                SerializationInfo info = iterator.next();
                Field field = this.getClass().getDeclaredField(info.getName());
                field.setAccessible(true);
                Object ourVal = field.get(this);
                field.setAccessible(false);

                // now use the getter to get their val
                Method getter = packetType.getMethod(toMethodName(info.getName()));
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
