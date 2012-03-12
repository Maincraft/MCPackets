package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface ChangeGameStatePacket extends Packet {
    byte getReason();
    byte getGameMode();
}
