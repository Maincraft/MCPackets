package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface PlayerLookPacket extends Packet {
    float getYaw();

    float getPitch();

    boolean getOnGround();
}
