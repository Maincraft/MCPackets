package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.DestroyEntityPacket;

@Deprecated
public final class DestroyEntityPacketSender extends AbstractPacketSender<DestroyEntityPacket> {
    @Override
    public void sendData(DataOutput stream, DestroyEntityPacket packet) throws IOException {
        stream.writeInt(packet.getEntityId());
    }
}
