package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.packet.KeepAlivePacket;
import tk.maincraft.util.mcpackets.packet.impl.KeepAlivePacketImpl;

public final class KeepAlivePacketHandler extends AbstractPacketHandler<KeepAlivePacket> {
    @Override
    public KeepAlivePacket doRead(DataInput stream) throws IOException {
        int id = stream.readInt();

        return new KeepAlivePacketImpl(id);
    }
}
