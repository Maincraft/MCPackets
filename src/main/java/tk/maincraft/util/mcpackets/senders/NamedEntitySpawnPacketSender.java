package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.packet.NamedEntitySpawnPacket;

@Deprecated
public final class NamedEntitySpawnPacketSender extends AbstractPacketSender<NamedEntitySpawnPacket> {
    @Override
    public void sendData(DataOutput stream, NamedEntitySpawnPacket packet) throws IOException {
        stream.writeInt(packet.getEntityId());
        NetUtils.writeString(stream, packet.getEntityName());
        stream.writeInt(packet.getX());
        stream.writeInt(packet.getY());
        stream.writeInt(packet.getZ());
        stream.writeByte(packet.getYaw());
        stream.writeByte(packet.getPitch());
        stream.writeShort(packet.getCurrentItem());
    }
}
