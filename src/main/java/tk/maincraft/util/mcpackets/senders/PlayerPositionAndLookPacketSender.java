package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.PlayerPositionAndLookPacket;

@Deprecated
public final class PlayerPositionAndLookPacketSender extends AbstractPacketSender<PlayerPositionAndLookPacket> {
    @Override
    public void sendData(DataOutput stream, PlayerPositionAndLookPacket packet)
            throws IOException {
        stream.writeDouble(packet.getX());
        stream.writeDouble(packet.getY());
        stream.writeDouble(packet.getStance());
        stream.writeDouble(packet.getZ());
        stream.writeFloat(packet.getYaw());
        stream.writeFloat(packet.getPitch());
        stream.writeBoolean(packet.getOnGround());
    }
}
