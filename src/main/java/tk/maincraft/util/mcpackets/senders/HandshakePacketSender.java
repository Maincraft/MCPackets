package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.packet.HandshakePacket;

@Deprecated
public final class HandshakePacketSender extends AbstractPacketSender<HandshakePacket> {
    @Override
    public void sendData(DataOutput stream, HandshakePacket packet) throws IOException {
        NetUtils.writeString(stream, packet.getMessageOrUsername());
    }
}
