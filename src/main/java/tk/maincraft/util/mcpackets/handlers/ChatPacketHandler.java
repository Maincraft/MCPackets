package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.packet.ChatPacket;
import tk.maincraft.util.mcpackets.packet.impl.ChatPacketImpl;

public final class ChatPacketHandler extends AbstractPacketHandler<ChatPacket> {
    @Override
    public ChatPacket doRead(DataInput stream) throws IOException {
        String message = NetUtils.readString(stream, 500);

        return new ChatPacketImpl(message);
    }
}
