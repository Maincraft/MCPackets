package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface BlockActionPacket extends Packet {
    int getX();
    short getY();
    int getZ();
    byte getByte1();
    byte getByte2();
}
