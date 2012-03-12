package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.EntityLookPacket;

@Deprecated
public final class EntityLookPacketSender extends AbstractPacketSender<EntityLookPacket> {
    @Override
    public void sendData(DataOutput stream, EntityLookPacket packet) throws IOException {
        stream.writeInt(packet.getEntityId());
        stream.writeByte(packet.getYaw());
        stream.writeByte(packet.getPitch());
    }
}
