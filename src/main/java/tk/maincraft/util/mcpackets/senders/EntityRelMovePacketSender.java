package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.EntityRelMovePacket;

@Deprecated
public final class EntityRelMovePacketSender extends AbstractPacketSender<EntityRelMovePacket> {
    @Override
    public void sendData(DataOutput stream, EntityRelMovePacket packet) throws IOException {
        stream.writeInt(packet.getEntityId());
        stream.writeByte(packet.getDiffX());
        stream.writeByte(packet.getDiffY());
        stream.writeByte(packet.getDiffZ());
    }
}
