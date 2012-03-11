package tk.maincraft.util.mcpackets.serialization;

import static tk.maincraft.util.mcpackets.serialization.SerializationHelper.*;

import java.io.DataOutput;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ListIterator;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.PacketSender;

public class SerializationPacketSender<T extends Packet> implements PacketSender<T> {
    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void send(DataOutput stream, T packet) {
        try {
            Class<? extends Packet> iFace = getPacketInterface(packet.getClass());
            List<SerializationInfo> serInfos = getSerializationInfos(iFace);
            /*
             * dirty: we have to have "getProperty()" to get "property"
             */
            ListIterator<SerializationInfo> iterator = serInfos.listIterator();
            while (iterator.hasNext()) {
                SerializationInfo now = iterator.next();
                Method getter = iFace.getMethod(toMethodName(now.getName()));
                Serializor serializor = now.getSerialize().type().getSerializor();
                serializor.write(stream, getter.invoke(packet));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
