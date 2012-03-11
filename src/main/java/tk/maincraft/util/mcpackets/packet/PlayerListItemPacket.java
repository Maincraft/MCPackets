package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface PlayerListItemPacket extends Packet {
    String getPlayerName();

    boolean getOnlineStatus();

    short getPing();
}
