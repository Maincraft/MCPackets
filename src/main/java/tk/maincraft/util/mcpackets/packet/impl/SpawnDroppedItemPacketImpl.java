package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.SpawnDroppedItemPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class SpawnDroppedItemPacketImpl extends AbstractPacket implements SpawnDroppedItemPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int entityId;
    @Serialize(type = Type.SHORT, order = 1)
    private final short itemId;
    @Serialize(type = Type.BYTE, order = 2)
    private final byte count;
    @Serialize(type = Type.SHORT, order = 3)
    private final short dataValue;
    @Serialize(type = Type.INT, order = 4)
    private final int x;
    @Serialize(type = Type.INT, order = 5)
    private final int y;
    @Serialize(type = Type.INT, order = 6)
    private final int z;
    @Serialize(type = Type.BYTE, order = 7)
    private final byte rotation;
    @Serialize(type = Type.BYTE, order = 8)
    private final byte pitch;
    @Serialize(type = Type.BYTE, order = 9)
    private final byte roll;

    public SpawnDroppedItemPacketImpl(int entityId, short itemId, byte count, short dataValue,
            int x, int y, int z, byte rotation, byte pitch, byte roll) {
        super();
        this.entityId = entityId;
        this.itemId = itemId;
        this.count = count;
        this.dataValue = dataValue;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rotation = rotation;
        this.pitch = pitch;
        this.roll = roll;
    }

    @Override
    public int getOpcode() {
        return 0x15;
    }

    @Override
    public int getEntityId() {
        return entityId;
    }

    @Override
    public short getItemId() {
        return itemId;
    }

    @Override
    public byte getCount() {
        return count;
    }

    @Override
    public short getDataValue() {
        return dataValue;
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
    public byte getRotation() {
        return rotation;
    }

    @Override
    public byte getPitch() {
        return pitch;
    }

    @Override
    public byte getRoll() {
        return roll;
    }

    @Override
    public String getToStringDescription() {
        return String.format("entityId=\"%d\",itemId=\"%d\",count=\"%d\",dataValue=\"%d\","
                + "x=\"%d\",y=\"%d\",z=\"%d\",rotation=\"%d\",pitch=\"%d\",roll=\"%d\"",
                entityId, itemId, count, dataValue, x, y, z, rotation, pitch, roll);
    }
}
