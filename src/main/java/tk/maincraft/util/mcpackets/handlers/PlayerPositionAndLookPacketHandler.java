package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.PlayerPositionAndLookPacket;
import tk.maincraft.util.mcpackets.packet.impl.PlayerPositionAndLookPacketImpl;

@Deprecated
public final class PlayerPositionAndLookPacketHandler extends AbstractPacketHandler<PlayerPositionAndLookPacket> {
    @Override
    public PlayerPositionAndLookPacket doRead(DataInput stream) throws IOException {
        double x = stream.readDouble();
        double y = stream.readDouble();
        double stance = stream.readDouble();
        double z = stream.readDouble();
        float yaw = stream.readFloat();
        float pitch = stream.readFloat();
        boolean onGround = stream.readBoolean();

        return new PlayerPositionAndLookPacketImpl(x, y, stance, z, yaw, pitch, onGround);
    }
}
