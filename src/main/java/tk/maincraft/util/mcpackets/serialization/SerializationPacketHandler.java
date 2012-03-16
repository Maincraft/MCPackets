package tk.maincraft.util.mcpackets.serialization;

import static tk.maincraft.util.mcpackets.serialization.SerializationHelper.*;

import java.io.DataInput;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.Set;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.PacketHandler;

/*
 * This is magic. AWESOME magic!
 */
public class SerializationPacketHandler<T extends Packet> implements PacketHandler<T> {
    @SuppressWarnings("rawtypes")
    @Override
    public T handle(DataInput in, Class<T> type) {
        try {
            // get the implementation-class
            Class<? extends T> implClazz = getImplClass(type);
            List<SerializationInfo> serInfos = getSerializationInfos(type);
            Object[] params = new Object[serInfos.size()];
            Class<?>[] paramTypes = new Class<?>[serInfos.size()];
            for (int i = 0; i < serInfos.size(); i++) {
                Serialize serialize = serInfos.get(i).getSerialize();
                Serializor serializor = serialize.type().getSerializor();
                if (serializor instanceof ObjectUsingSerializor) {
                    ObjectUsingSerializor ous = (ObjectUsingSerializor) serializor;
                    params[i] = ous.read(in, params[serialize.moreInfo()]);
                } else {
                    params[i] = serializor.read(in);
                }
                Class<?> paramClazz = params[i].getClass();
                if (Map.class.isAssignableFrom(paramClazz))
                    paramClazz = Map.class;
                if (Set.class.isAssignableFrom(paramClazz))
                    paramClazz = Set.class;
                paramTypes[i] = paramClazz;
            }
            Constructor<? extends T> ctor = implClazz.getConstructor(fixupClasses(paramTypes));
            return ctor.newInstance(params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
