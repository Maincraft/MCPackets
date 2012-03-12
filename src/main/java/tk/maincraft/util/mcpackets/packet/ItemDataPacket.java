package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface ItemDataPacket extends Packet {
    short getItemType();
    short getItemId();
    byte getDataLength();
    byte[] getData();
}
