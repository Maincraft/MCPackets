package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.SpawnPositionPacket;

public final class SpawnPositionPacketSender extends AbstractPacketSender<SpawnPositionPacket> {
    @Override
    public void sendData(DataOutput stream, SpawnPositionPacket packet) throws IOException {
        stream.writeInt(packet.getX());
        stream.writeInt(packet.getY());
        stream.writeInt(packet.getZ());
    }
}
