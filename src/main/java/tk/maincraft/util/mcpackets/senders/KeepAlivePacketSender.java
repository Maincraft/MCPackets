package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.KeepAlivePacket;

@Deprecated
public final class KeepAlivePacketSender extends AbstractPacketSender<KeepAlivePacket> {
    @Override
    public void sendData(DataOutput stream, KeepAlivePacket packet) throws IOException {
        stream.writeInt(packet.getToken());
    }
}
