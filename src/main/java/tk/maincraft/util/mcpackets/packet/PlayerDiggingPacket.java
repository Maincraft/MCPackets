package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface PlayerDiggingPacket extends Packet {
    byte getStatus();
    int getX();
    byte getY();
    int getZ();
    byte getFace();
}
