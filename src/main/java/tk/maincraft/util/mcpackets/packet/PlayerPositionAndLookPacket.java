package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface PlayerPositionAndLookPacket extends Packet {
    double getX();

    // client -> server: Y
    // client <- server: stance
    double getYOrStance();

    // client -> server: stance
    // client <- server: Y
    double getStanceOrY();

    double getZ();

    float getYaw();

    float getPitch();

    boolean getOnGround();
}
