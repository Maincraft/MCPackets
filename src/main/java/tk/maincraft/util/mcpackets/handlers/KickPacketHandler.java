package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.packet.KickPacket;
import tk.maincraft.util.mcpackets.packet.impl.KickPacketImpl;

public final class KickPacketHandler extends AbstractPacketHandler<KickPacket> {
    @Override
    public KickPacket doRead(DataInput stream) throws IOException {
        String reason = NetUtils.readString(stream, 1000);

        return new KickPacketImpl(reason);
    }
}
