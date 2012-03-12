package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;

import tk.maincraft.util.mcpackets.packet.ServerListPingPacket;
import tk.maincraft.util.mcpackets.packet.impl.ServerListPingPacketImpl;

@Deprecated
public final class ServerListPingPacketHandler extends AbstractPacketHandler<ServerListPingPacket> {
    @Override
    public ServerListPingPacket doRead(DataInput stream) {
        return new ServerListPingPacketImpl();
    }
}
