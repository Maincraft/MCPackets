package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.EntityLookAndRelMovePacket;

public final class EntityLookAndRelMovePacketSender extends AbstractPacketSender<EntityLookAndRelMovePacket> {
    @Override
    public void sendData(DataOutput stream, EntityLookAndRelMovePacket packet) throws IOException {
        stream.writeInt(packet.getEntityId());
        stream.writeByte(packet.getDiffX());
        stream.writeByte(packet.getDiffY());
        stream.writeByte(packet.getDiffZ());
        stream.writeByte(packet.getYaw());
        stream.writeByte(packet.getPitch());
    }
}
