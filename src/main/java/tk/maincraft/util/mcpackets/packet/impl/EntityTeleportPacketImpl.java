package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.RotationUtils;
import tk.maincraft.util.mcpackets.packet.EntityTeleportPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class EntityTeleportPacketImpl extends AbstractPacket implements EntityTeleportPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int entityId;
    @Serialize(type = Type.INT, order = 1)
    private final int x;
    @Serialize(type = Type.INT, order = 2)
    private final int y;
    @Serialize(type = Type.INT, order = 3)
    private final int z;
    @Serialize(type = Type.BYTE, order = 4)
    private final byte yaw;
    @Serialize(type = Type.BYTE, order = 5)
    private final byte pitch;

    public EntityTeleportPacketImpl(int entityId, int x, int y, int z, float yaw, float pitch) {
        this(entityId, x, y, z, RotationUtils.floatToByte(yaw), RotationUtils.floatToByte(pitch));
    }

    public EntityTeleportPacketImpl(int entityId, int x, int y, int z, byte yaw, byte pitch) {
        super();
        this.entityId = entityId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    @Override
    public int getOpcode() {
        return 0x22;
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
    public int getEntityId() {
        return entityId;
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
    public String getToStringDescription() {
        return String.format("entityId=\"%d\",x=\"%d\",y=\"%d\",z=\"%d\",yaw=\"%d\",pitch=\"%d\"",
                entityId, x, y, z, yaw, pitch);
    }
}
