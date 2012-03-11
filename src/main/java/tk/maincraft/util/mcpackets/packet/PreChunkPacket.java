package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

// also called "MapColumnAllocation". However, I prefer the name "PreChunk" :P
public interface PreChunkPacket extends Packet {
    int getX();

    int getZ();

    boolean getMode();
}
