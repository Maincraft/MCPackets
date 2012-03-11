package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.PlayerPositionPacket;
import tk.maincraft.util.mcpackets.packet.impl.PlayerPositionPacketImpl;

public final class PlayerPositionPacketHandler extends AbstractPacketHandler<PlayerPositionPacket> {
    @Override
    public PlayerPositionPacket doRead(DataInput stream) throws IOException {
        double x = stream.readDouble();
        double y = stream.readDouble();
        double stance = stream.readDouble();
        double z = stream.readDouble();
        boolean onGround = stream.readBoolean();

        return new PlayerPositionPacketImpl(x, y, stance, z, onGround);
    }
}
