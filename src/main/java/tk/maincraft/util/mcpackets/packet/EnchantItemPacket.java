package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface EnchantItemPacket extends Packet {
    byte getWindowId();
    byte getEnchantment();
}
