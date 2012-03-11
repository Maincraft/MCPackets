package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.packet.PlayerListItemPacket;

public final class PlayerListItemPacketSender extends AbstractPacketSender<PlayerListItemPacket> {
    @Override
    public void sendData(DataOutput stream, PlayerListItemPacket packet) throws IOException {
        NetUtils.writeString(stream, packet.getPlayerName());
        stream.writeBoolean(packet.getOnlineStatus());
        stream.writeShort(packet.getPing());
    }
}
