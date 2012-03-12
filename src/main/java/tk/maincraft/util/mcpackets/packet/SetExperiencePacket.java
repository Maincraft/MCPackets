package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface SetExperiencePacket extends Packet {
    float getExperienceBar();
    short getLevel();
    short getTotalExperience();
}
