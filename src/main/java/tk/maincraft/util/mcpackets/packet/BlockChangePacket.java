package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface BlockChangePacket extends Packet {
    int getX();
    byte getY();
    int getZ();
    byte getBlockType();
    byte getBlockMetadata();
}
