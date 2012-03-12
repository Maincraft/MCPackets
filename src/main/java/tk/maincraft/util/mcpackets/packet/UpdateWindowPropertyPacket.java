package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface UpdateWindowPropertyPacket extends Packet {
    byte getWindowId();
    short getProperty();
    short getValue();
}
