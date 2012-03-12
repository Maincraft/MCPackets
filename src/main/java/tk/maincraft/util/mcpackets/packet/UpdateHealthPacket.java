package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface UpdateHealthPacket extends Packet {
    short getHealth();
    short getFood();
    float getSaturation();
}
