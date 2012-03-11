package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface PlayerPositionPacket extends Packet {
    double getX();

    double getY();

    double getStance();

    double getZ();

    boolean isOnGround();
}
