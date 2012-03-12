package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.misc.ItemStack;

public interface SetSlotPacket extends Packet {
    byte getWindowId();
    short getSlot();
    ItemStack getItem();
}
