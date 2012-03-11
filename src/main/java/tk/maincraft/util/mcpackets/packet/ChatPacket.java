package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface ChatPacket extends Packet {
    String getMessage();
}
