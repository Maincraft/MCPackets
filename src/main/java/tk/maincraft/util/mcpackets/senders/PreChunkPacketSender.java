package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.PreChunkPacket;

@Deprecated
public final class PreChunkPacketSender extends AbstractPacketSender<PreChunkPacket> {
    @Override
    public void sendData(DataOutput stream, PreChunkPacket packet) throws IOException {
        stream.writeInt(packet.getX());
        stream.writeInt(packet.getZ());
        stream.writeBoolean(packet.getMode());
    }
}
