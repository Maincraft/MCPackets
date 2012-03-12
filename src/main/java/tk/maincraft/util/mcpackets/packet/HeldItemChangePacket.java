package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface HeldItemChangePacket extends Packet {
    short getSlotId();
}
