package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.ServerListPingPacket;

public class ServerListPingPacketImpl extends AbstractPacket implements ServerListPingPacket {
    public ServerListPingPacketImpl() {
        super();
    }

    @Override
    public int getOpcode() {
        return 254;
    }

    @Override
    public String getToStringDescription() {
        return new String();
    }
}
