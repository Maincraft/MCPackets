package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface OpenWindowPacket extends Packet {
    byte getWindowId();
    byte getInventoryType();
    String getWindowTitle();
    byte getNumberOfSlots();
}
