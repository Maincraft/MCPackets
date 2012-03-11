package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.PlayerOnGroundPacket;
import tk.maincraft.util.mcpackets.packet.impl.PlayerOnGroundPacketImpl;

public final class PlayerOnGroundPacketHandler extends AbstractPacketHandler<PlayerOnGroundPacket> {
    @Override
    public PlayerOnGroundPacket doRead(DataInput stream) throws IOException {
        boolean onGround = stream.readBoolean();

        return new PlayerOnGroundPacketImpl(onGround);
    }
}
