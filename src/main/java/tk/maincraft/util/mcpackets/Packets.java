package tk.maincraft.util.mcpackets;

import java.util.HashMap;
import java.util.Map;

import tk.maincraft.util.mcpackets.packet.*;

public final class Packets {
    /**
     * The Minecraft protocol-version this version of the library is implementing.
     */
    public static final int PROTOCOL_VERSION = 29;

    private static final Map<Integer, Class<? extends Packet>> classMappings =
            new HashMap<Integer, Class<? extends Packet>>();

    static {
        registerPacket(0x00, KeepAlivePacket.class);
        registerPacket(0x01, LoginPacket.class);
        registerPacket(0x02, HandshakePacket.class);
        registerPacket(0x03, ChatPacket.class);
        registerPacket(0x04, TimeUpdatePacket.class);
        registerPacket(0x05, EntityEquipmentPacket.class);
        registerPacket(0x06, SpawnPositionPacket.class);
        registerPacket(0x07, UseEntityPacket.class);
        registerPacket(0x08, UpdateHealthPacket.class);
        registerPacket(0x09, PlayerRespawnPacket.class);
        registerPacket(0x0A, PlayerOnGroundPacket.class);
        registerPacket(0x0B, PlayerPositionPacket.class);
        registerPacket(0x0C, PlayerLookPacket.class);
        registerPacket(0x0D, PlayerPositionAndLookPacket.class);
        registerPacket(0x0E, PlayerDiggingPacket.class);
        registerPacket(0x0F, PlayerBlockPlacementPacket.class);
        registerPacket(0x10, HeldItemChangePacket.class);
        registerPacket(0x11, UseBedPacket.class);
        registerPacket(0x12, AnimationPacket.class);
        registerPacket(0x13, EntityActionPacket.class);
        registerPacket(0x14, NamedEntitySpawnPacket.class);
        registerPacket(0x15, SpawnDroppedItemPacket.class);
        registerPacket(0x16, ItemCollectPacket.class);
        registerPacket(0x17, SpawnObjectPacket.class);
        registerPacket(0x18, SpawnMobPacket.class);
        registerPacket(0x19, SpawnPaintingPacket.class);
        registerPacket(0x1A, SpawnExperienceOrbPacket.class);
        registerPacket(0x1C, EntityVelocityPacket.class);
        registerPacket(0x1D, DestroyEntityPacket.class);
        registerPacket(0x1E, EntityExistsPacket.class);
        registerPacket(0x1F, EntityRelMovePacket.class);
        registerPacket(0x20, EntityLookPacket.class);
        registerPacket(0x21, EntityLookAndRelMovePacket.class);
        registerPacket(0x22, EntityTeleportPacket.class);
        registerPacket(0x23, EntityHeadLookPacket.class);
        registerPacket(0x26, EntityStatusPacket.class);
        registerPacket(0x27, AttachEntityPacket.class);
        registerPacket(0x28, EntityMetadataPacket.class);
        registerPacket(0x29, EntityEffectPacket.class);
        registerPacket(0x2A, RemoveEntityEffectPacket.class);
        registerPacket(0x2B, SetExperiencePacket.class);
        registerPacket(0x32, PreChunkPacket.class);
        registerPacket(0x33, MapChunkPacket.class);
        registerPacket(0x34, MultiBlockChangePacket.class);
        registerPacket(0x35, BlockChangePacket.class);
        registerPacket(0x36, BlockActionPacket.class);
        registerPacket(0x3C, ExplosionPacket.class);
        registerPacket(0x3D, SoundOrParticleEffectPacket.class);
        registerPacket(0x46, ChangeGameStatePacket.class);
        registerPacket(0x47, ThunderboltPacket.class);
        registerPacket(0x64, OpenWindowPacket.class);
        registerPacket(0x65, CloseWindowPacket.class);
        registerPacket(0x66, ClickWindowPacket.class);
        registerPacket(0x67, SetSlotPacket.class);
        registerPacket(0x68, SetWindowItemsPacket.class);
        registerPacket(0x69, UpdateWindowPropertyPacket.class);
        registerPacket(0x6A, ConfirmTransactionPacket.class);
        registerPacket(0x6B, CreativeInventoryActionPacket.class);
        registerPacket(0x6C, EnchantItemPacket.class);
        registerPacket(0x82, UpdateSignPacket.class);
        registerPacket(0x83, ItemDataPacket.class);
        registerPacket(0x84, UpdateTileEntityPacket.class);
        registerPacket(0xC8, IncrementStatisticPacket.class);
        registerPacket(0xC9, PlayerListItemPacket.class);
        registerPacket(0xCA, PlayerAbilitiesPacket.class);
        registerPacket(0xFA, PluginMessagePacket.class);
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
