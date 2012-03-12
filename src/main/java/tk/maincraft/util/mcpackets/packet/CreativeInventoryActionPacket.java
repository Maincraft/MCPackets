package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.misc.ItemStack;

public interface CreativeInventoryActionPacket extends Packet {
    short getSlot();
    ItemStack getItem();
}
