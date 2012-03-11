package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface NamedEntitySpawnPacket extends Packet {
    int getEntityId();

    String getEntityName();

    int getX();

    int getY();

    int getZ();

    byte getYaw();

    byte getPitch();

    short getCurrentItem();
}
