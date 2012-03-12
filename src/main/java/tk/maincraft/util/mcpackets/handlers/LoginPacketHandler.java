package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.packet.LoginPacket;
import tk.maincraft.util.mcpackets.packet.impl.LoginPacketImpl;

@Deprecated
public final class LoginPacketHandler extends AbstractPacketHandler<LoginPacket> {
    @Override
    public LoginPacket doRead(DataInput stream) throws IOException {
        int protocolVersionOrEntityId = stream.readInt();
        String username = NetUtils.readString(stream, 100);
        String levelType = NetUtils.readString(stream, 100);
        int mode = stream.readInt();
        int dimension = stream.readInt();
        byte difficulty = stream.readByte();
        int worldHeight = stream.readUnsignedByte();
        int maxPlayers = stream.readUnsignedByte();

        return new LoginPacketImpl(protocolVersionOrEntityId, username, levelType, mode, dimension, difficulty, worldHeight, maxPlayers);
    }
}
