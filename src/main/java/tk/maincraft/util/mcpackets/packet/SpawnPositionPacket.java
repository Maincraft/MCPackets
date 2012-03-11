package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface SpawnPositionPacket extends Packet {
    int getX();

    int getY();

    int getZ();
}
