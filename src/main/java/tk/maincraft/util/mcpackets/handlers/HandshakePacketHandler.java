package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.packet.HandshakePacket;
import tk.maincraft.util.mcpackets.packet.impl.HandshakePacketImpl;

public final class HandshakePacketHandler extends AbstractPacketHandler<HandshakePacket> {
    @Override
    public HandshakePacket doRead(DataInput stream) throws IOException {
        String username = NetUtils.readString(stream, 32);

        return new HandshakePacketImpl(username);
    }
}
