package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.NamedEntitySpawnPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class NamedEntitySpawnPacketImpl extends AbstractPacket implements NamedEntitySpawnPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int entityId;
    @Serialize(type = Type.STRING, order = 1)
    private final String entityName;
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
    @Serialize(type = Type.SHORT, order = 7)
    private final short currentItem;

    public NamedEntitySpawnPacketImpl(int entityId, String playerName, int x, int y, int z, byte yaw, byte pitch, short currentItem) {
        super();
        this.entityId = entityId;
        this.entityName = playerName;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.currentItem = currentItem;
    }

    @Override
    public int getOpcode() {
        return 0x14;
    }

    @Override
    public int getEntityId() {
        return entityId;
    }

    @Override
    public String getEntityName() {
        return entityName;
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
    public short getCurrentItem() {
        return currentItem;
    }

    @Override
    public String getToStringDescription() {
        return String.format("entityId=\"%d\",playerName=\"%s\",x=\"%d\",y=\"%d\",z=\"%d\",yaw=\"%d\",pitch=\"%d\",currentItem=\"%d\"",
                        entityId, entityName, x, y, z, yaw, pitch, currentItem);
    }
}
