package tk.maincraft.util.mcpackets;

import java.util.HashMap;
import java.util.Map;

import tk.maincraft.util.mcpackets.senders.*;

@Deprecated
public final class PacketSenderFactory {
    private PacketSenderFactory() {
    }

    private static final Map<Integer, Class<? extends PacketSender<? extends Packet>>> classMappings = new HashMap<Integer, Class<? extends PacketSender<? extends Packet>>>();
    private static final Map<Integer, PacketSender<? extends Packet>> objMappings = new HashMap<Integer, PacketSender<? extends Packet>>();

    static {
        registerSender(0x00, KeepAlivePacketSender.class);
        registerSender(0x01, LoginPacketSender.class);
        registerSender(0x02, HandshakePacketSender.class);
        registerSender(0x03, ChatPacketSender.class);
        registerSender(0x06, SpawnPositionPacketSender.class);
        registerSender(0x0D, PlayerPositionAndLookPacketSender.class);
        registerSender(0x14, NamedEntitySpawnPacketSender.class);
        registerSender(0x1D, DestroyEntityPacketSender.class);
        registerSender(0x1F, EntityRelMovePacketSender.class);
        registerSender(0x20, EntityLookPacketSender.class);
        registerSender(0x21, EntityLookAndRelMovePacketSender.class);
        registerSender(0x22, EntityTeleportPacketSender.class);
        registerSender(0x32, PreChunkPacketSender.class);
        registerSender(0x33, MapChunkPacketSender.class);
        registerSender(0xC9, PlayerListItemPacketSender.class);
        registerSender(0xFF, KickPacketSender.class);
    }

    public static PacketSender<?> getNewPacketSender(int opcode) throws UnknownPacketException {
        try {
            if (objMappings.containsKey(opcode))
                return objMappings.get(opcode);
            else {
                Class<? extends PacketSender<? extends Packet>> clazz = classMappings.get(opcode);
                PacketSender<? extends Packet> newSender = clazz.newInstance();
                objMappings.put(opcode, newSender);
                return newSender;
            }
        } catch (Exception e) {
            throw new UnknownPacketException(opcode, e);
        }
    }

    public static void registerSender(int opcode,
            Class<? extends PacketSender<? extends Packet>> sender) {
        classMappings.put(opcode, sender);
    }
}
