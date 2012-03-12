package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.misc.ItemStack;

public interface SetWindowItemsPacket extends Packet {
    byte getWindowId();
    short getSize();
    ItemStack[] getItems();
}
