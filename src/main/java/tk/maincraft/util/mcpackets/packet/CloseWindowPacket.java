package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface CloseWindowPacket extends Packet {
    byte getWindowId();
}
