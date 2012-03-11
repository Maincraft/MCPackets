package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.packet.ChatPacket;

public final class ChatPacketSender extends AbstractPacketSender<ChatPacket> {
    @Override
    public void sendData(DataOutput stream, ChatPacket packet) throws IOException {
        NetUtils.writeString(stream, packet.getMessage());
    }
}
