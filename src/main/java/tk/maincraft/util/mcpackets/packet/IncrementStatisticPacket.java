package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface IncrementStatisticPacket extends Packet {
    int getStatisticId();
    byte getAmount();
}
