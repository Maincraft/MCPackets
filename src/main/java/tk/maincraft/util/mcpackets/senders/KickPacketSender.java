package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.packet.KickPacket;

@Deprecated
public final class KickPacketSender extends AbstractPacketSender<KickPacket> {
    @Override
    public void sendData(DataOutput stream, KickPacket packet) throws IOException {
        NetUtils.writeString(stream, packet.getReason());
    }
}
