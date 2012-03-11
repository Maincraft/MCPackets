package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.PlayerPositionAndLookPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class PlayerPositionAndLookPacketImpl extends AbstractPacket implements PlayerPositionAndLookPacket {
    @Serialize(type = Type.DOUBLE, order = 0)
    private final double x;
    @Serialize(type = Type.DOUBLE, order = 1)
    private final double y;
    @Serialize(type = Type.DOUBLE, order = 2)
    private final double stance;
    @Serialize(type = Type.DOUBLE, order = 3)
    private final double z;
    @Serialize(type = Type.FLOAT, order = 4)
    private final float yaw;
    @Serialize(type = Type.FLOAT, order = 5)
    private final float pitch;
    @Serialize(type = Type.BOOL, order = 6)
    private final boolean onGround;

    public PlayerPositionAndLookPacketImpl(double x, double y, double stance, double z, float yaw, float pitch, boolean onGround) {
        super();
        this.x = x;
        this.y = y;
        this.stance = stance;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }

    @Override
    public int getOpcode() {
        return 0x0D; // packet 13 / 0x0D
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getStance() {
        return stance;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public float getYaw() {
        return yaw;
    }

    @Override
    public float getPitch() {
        return pitch;
    }

    @Override
    public boolean isOnGround() {
        return onGround;
    }

    @Override
    public String getToStringDescription() {
        return String.format(
                "x=\"%f\",y=\"%f\",stance=\"%f\",z=\"%f\",yaw=\"%f\",pitch=\"%f\",onGround=\"%b\"",
                x, y, stance, z, yaw, pitch, onGround);
    }
}
