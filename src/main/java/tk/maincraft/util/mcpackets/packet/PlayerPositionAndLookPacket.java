package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface PlayerPositionAndLookPacket extends Packet {
    double getX();

    /*
     * y and stance might be swapped
     */
    double getY();

    double getStance();

    double getZ();

    float getYaw();

    float getPitch();

    boolean getOnGround();
}
