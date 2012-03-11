package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.packet.LoginPacket;

public final class LoginPacketSender extends AbstractPacketSender<LoginPacket> {
    @Override
    public void sendData(DataOutput stream, LoginPacket packet) throws IOException {
        stream.writeInt(packet.getProtocolVersionOrEntityId());
        NetUtils.writeString(stream, packet.getUsername());
        NetUtils.writeString(stream, packet.getLevelType());
        stream.writeInt(packet.getMode());
        stream.writeInt(packet.getDimension());
        stream.writeByte(packet.getDifficulty());
        stream.writeByte(packet.getWorldHeight());
        stream.writeByte(packet.getMaxPlayers());
    }
}
