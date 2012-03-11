package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface LoginPacket extends Packet {
    int getProtocolVersionOrEntityId();

    String getUsername();

    String getLevelType();

    int getMode();

    int getDimension();

    byte getDifficulty();

    int getWorldHeight();

    int getMaxPlayers();
}
