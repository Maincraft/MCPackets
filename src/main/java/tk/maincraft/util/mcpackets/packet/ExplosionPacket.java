package tk.maincraft.util.mcpackets.packet;

import java.util.Set;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.misc.BlockCoords;

public interface ExplosionPacket extends Packet {
    double getX();
    double getY();
    double getZ();
    float getSize();
    Set<BlockCoords> getDestroyedBlocks(); // these BlockCoords are relative!
}
