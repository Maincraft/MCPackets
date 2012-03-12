package tk.maincraft.util.mcpackets.packet.impl;

import java.util.Map;

import tk.maincraft.util.mcpackets.misc.EntityMetadata;
import tk.maincraft.util.mcpackets.packet.SpawnMobPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class SpawnMobPacketImpl extends AbstractPacket implements SpawnMobPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int entityId;
    @Serialize(type = Type.BYTE, order = 1)
    private final byte entityType;
    @Serialize(type = Type.INT, order = 2)
    private final int x;
    @Serialize(type = Type.INT, order = 3)
    private final int y;
    @Serialize(type = Type.INT, order = 4)
    private final int z;
    @Serialize(type = Type.BYTE, order = 5)
    private final byte yaw;
    @Serialize(type = Type.BYTE, order = 6)
    private final byte pitch;
    @Serialize(type = Type.BYTE, order = 7)
    private final byte headYaw;
    @Serialize(type = Type.ENTITY_METADATA, order = 8)
    private final Map<Integer, EntityMetadata<?>> metadata;

    public SpawnMobPacketImpl(int entityId, byte entityType, int x, int y, int z,
            byte yaw, byte pitch, byte headYaw, Map<Integer, EntityMetadata<?>> metadata) {
        super();
        this.entityId = entityId;
        this.entityType = entityType;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.headYaw = headYaw;
        this.metadata = metadata;
    }

    @Override
    public int getOpcode() {
        return 0x18;
    }

    @Override
    public int getEntityId() {
        return entityId;
    }

    @Override
    public byte getEntityType() {
        return entityType;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public byte getYaw() {
        return yaw;
    }

    @Override
    public byte getPitch() {
        return pitch;
    }

    @Override
    public byte getHeadYaw() {
        return headYaw;
    }

    @Override
    public Map<Integer, EntityMetadata<?>> getMetadata() {
        return metadata;
    }

    @Override
    public String getToStringDescription() {
        return String.format("entityId=\"%d\",entityType=\"%d\",x=\"%d\",y=\"%d\",z=\"%d\","
                + "yaw=\"%d\",pitch=\"%d\",headYaw=\"%d\",metadata=\"%s\"",
                entityId, entityType, x, y, z, yaw, pitch, headYaw, metadata);
    }
}
