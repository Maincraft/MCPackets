package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.SpawnObjectPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class SpawnObjectPacketImpl extends AbstractPacket implements SpawnObjectPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int entityId;
    @Serialize(type = Type.BYTE, order = 1)
    private final byte type;
    @Serialize(type = Type.INT, order = 2)
    private final int x;
    @Serialize(type = Type.INT, order = 3)
    private final int y;
    @Serialize(type = Type.INT, order = 4)
    private final int z;
    @Serialize(type = Type.INT, order = 5)
    private final int fireballThrower;
    @Serialize(type = Type.CONDITIONAL_SHORT, order = 6, moreInfo = 5)
    private final short fireballSpeedX;
    @Serialize(type = Type.CONDITIONAL_SHORT, order = 7, moreInfo = 5)
    private final short fireballSpeedY;
    @Serialize(type = Type.CONDITIONAL_SHORT, order = 8, moreInfo = 5)
    private final short fireballSpeedZ;

    public SpawnObjectPacketImpl(int entityId, byte type, int x, int y, int z, int fireballThrower, short fireballSpeedX, short fireballSpeedY, short fireballSpeedZ) {
        super();
        this.entityId = entityId;
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.fireballThrower = fireballThrower;
        this.fireballSpeedX = fireballSpeedX;
        this.fireballSpeedY = fireballSpeedY;
        this.fireballSpeedZ = fireballSpeedZ;
    }

    @Override
    public int getOpcode() {
        return 0x17;
    }

    @Override
    public int getEntityId() {
        return entityId;
    }

    @Override
    public byte getType() {
        return type;
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
    public int getFireballThrower() {
        return fireballThrower;
    }

    @Override
    public short getFireballSpeedX() {
        return fireballSpeedX;
    }

    @Override
    public short getFireballSpeedY() {
        return fireballSpeedY;
    }

    @Override
    public short getFireballSpeedZ() {
        return fireballSpeedZ;
    }

    @Override
    public String getToStringDescription() {
        return String.format("entityId=\"%d\",type=\"%d\",x=\"%d\",y=\"%d\",z=\"%d\",fireballThrower=\"%d\","
                        + "fireballSpeedX=\"%d\",fireballSpeedY=\"%d\",fireballSpeedZ=\"%d\"",
                        entityId, type, x, y, z, fireballThrower, fireballSpeedX, fireballSpeedY, fireballSpeedZ);
    }
}
