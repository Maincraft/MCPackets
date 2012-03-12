package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;
import tk.maincraft.util.mcpackets.packet.MapChunkPacket;

@Deprecated
public final class MapChunkPacketSender extends AbstractPacketSender<MapChunkPacket> {
    @Override
    public void sendData(DataOutput stream, MapChunkPacket packet) throws IOException {
        stream.writeInt(packet.getX());
        stream.writeInt(packet.getZ());
        stream.writeBoolean(packet.getGroundUpContinuous());
        stream.writeShort(packet.getPrimaryBitMap());
        stream.writeShort(packet.getAddBitMap());
        stream.writeInt(packet.getCompressedSize());
        stream.writeInt(packet.getUnused_int_0());
        stream.write(packet.getCompressedChunkData());
    }
}
