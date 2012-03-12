package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.PlayerLookPacket;
import tk.maincraft.util.mcpackets.packet.impl.PlayerLookPacketImpl;

@Deprecated
public final class PlayerLookPacketHandler extends AbstractPacketHandler<PlayerLookPacket> {
    @Override
    public PlayerLookPacket doRead(DataInput stream) throws IOException {
        float yaw = stream.readFloat();
        float pitch = stream.readFloat();
        boolean onGround = stream.readBoolean();

        return new PlayerLookPacketImpl(yaw, pitch, onGround);
    }
}
