package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface MultiBlockChangePacket extends Packet {
    int getChunkX();
    int getChunkZ();
    short getRecordCount();
    int getDataSize();
    byte[] getData();
}
