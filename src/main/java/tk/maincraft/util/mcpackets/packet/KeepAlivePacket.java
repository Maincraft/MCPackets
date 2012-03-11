package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface KeepAlivePacket extends Packet {
    int getToken();
}
