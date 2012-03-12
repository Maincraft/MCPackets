package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.misc.ItemStack;

public interface PlayerBlockPlacementPacket extends Packet {
    int getX();
    byte getY();
    int getZ();
    byte getDirection();
    ItemStack getHeldItem();
}
