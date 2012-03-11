package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.EntityTeleportPacket;

public final class EntityTeleportPacketSender extends AbstractPacketSender<EntityTeleportPacket> {
    @Override
    public void sendData(DataOutput stream, EntityTeleportPacket packet) throws IOException {
        stream.writeInt(packet.getEntityId());
        stream.writeInt(packet.getX());
        stream.writeInt(packet.getY());
        stream.writeInt(packet.getZ());
        stream.writeByte(packet.getYaw());
        stream.writeByte(packet.getPitch());
    }
}
