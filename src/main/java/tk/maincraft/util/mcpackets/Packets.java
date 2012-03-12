package tk.maincraft.util.mcpackets;

import java.util.HashMap;
import java.util.Map;

import tk.maincraft.util.mcpackets.packet.*;

public final class Packets {
    /**
     * The Minecraft protocol-version this version of the library is implementing.
     */
    public static final int PROTOCOL_VERSION = 28;

    private static final Map<Integer, Class<? extends Packet>> classMappings =
            new HashMap<Integer, Class<? extends Packet>>();

    static {
        registerPacket(0x00, KeepAlivePacket.class);
        registerPacket(0x01, LoginPacket.class);
        registerPacket(0x02, HandshakePacket.class);
        registerPacket(0x03, ChatPacket.class);
        registerPacket(0x06, SpawnPositionPacket.class);
        registerPacket(0x0A, PlayerOnGroundPacket.class);
        registerPacket(0x0B, PlayerPositionPacket.class);
        registerPacket(0x0C, PlayerLookPacket.class);
        registerPacket(0x0D, PlayerPositionAndLookPacket.class);
        registerPacket(0x14, NamedEntitySpawnPacket.class);
        registerPacket(0x1D, DestroyEntityPacket.class);
        registerPacket(0x1F, EntityRelMovePacket.class);
        registerPacket(0x20, EntityLookPacket.class);
        registerPacket(0x21, EntityLookAndRelMovePacket.class);
        registerPacket(0x22, EntityTeleportPacket.class);
        registerPacket(0x32, PreChunkPacket.class);
        registerPacket(0x33, MapChunkPacket.class);
        registerPacket(0xC9, PlayerListItemPacket.class);
        registerPacket(0xFE, ServerListPingPacket.class);
        registerPacket(0xFF, KickPacket.class);
    }

    public static Class<? extends Packet> lookupPacket(int opcode) throws UnknownPacketException {
        Class<? extends Packet> clazz = classMappings.get(opcode);
        if (clazz == null)
            throw new UnknownPacketException(opcode);
        return clazz;
    }

    public static void registerPacket(int opcode, Class<? extends Packet> clazz) {
        classMappings.put(opcode, clazz);
    }
}
