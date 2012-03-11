package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface KickPacket extends Packet {
    String getReason();
}
