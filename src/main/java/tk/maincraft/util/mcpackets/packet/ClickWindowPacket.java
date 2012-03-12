package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.misc.ItemStack;

public interface ClickWindowPacket extends Packet {
    byte getWindowId();
    short getSlot();
    byte getRightClick(); // 1 when rightclicking, otherwise 0
    short getAction();
    boolean getShiftHold();
    ItemStack getClickedItem();
}
