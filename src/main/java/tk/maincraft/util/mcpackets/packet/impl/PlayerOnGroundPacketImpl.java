package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.PlayerOnGroundPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class PlayerOnGroundPacketImpl extends AbstractPacket implements PlayerOnGroundPacket {
    @Serialize(type = Type.BOOL, order = 0)
    private final boolean onGround;

    public PlayerOnGroundPacketImpl(boolean onGround) {
        super();
        this.onGround = onGround;
    }

    @Override
    public int getOpcode() {
        return 0x0A;
    }

    @Override
    public boolean isOnGround() {
        return onGround;
    }

    @Override
    public String getToStringDescription() {
        return String.format("onGround=\"%b\"", onGround);
    }
}
