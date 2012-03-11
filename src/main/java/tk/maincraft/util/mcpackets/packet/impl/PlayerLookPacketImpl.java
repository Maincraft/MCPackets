package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.PlayerLookPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class PlayerLookPacketImpl extends AbstractPacket implements PlayerLookPacket {
    @Serialize(type = Type.FLOAT, order = 0)
    private final float yaw;
    @Serialize(type = Type.FLOAT, order = 1)
    private final float pitch;
    @Serialize(type = Type.BOOL, order = 2)
    private final boolean onGround;

    public PlayerLookPacketImpl(float yaw, float pitch, boolean onGround) {
        super();
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }

    @Override
    public int getOpcode() {
        return 0x0C;
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
        return String.format("yaw=\"%f\",pitch=\"%f\",onGround=\"%b\"", yaw, pitch, onGround);
    }
}
