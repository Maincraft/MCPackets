package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface TimeUpdatePacket extends Packet {
    long getTime();
}
