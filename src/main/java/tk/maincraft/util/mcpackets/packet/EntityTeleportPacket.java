package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface EntityTeleportPacket extends Packet {
    int getEntityId();

    int getX();

    int getY();

    int getZ();

    byte getYaw();

    byte getPitch();
}
