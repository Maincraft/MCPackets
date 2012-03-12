package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface SpawnExperienceOrbPacket extends Packet {
    int getEntityId();
    int getX();
    int getY();
    int getZ();
    short getCount();
}
