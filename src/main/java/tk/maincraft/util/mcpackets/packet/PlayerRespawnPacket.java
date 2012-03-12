package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface PlayerRespawnPacket extends Packet {
    int getDimension();
    byte getDifficulty();
    byte getGameMode();
    short getWorldHeight();
    String getLevelType();
}
