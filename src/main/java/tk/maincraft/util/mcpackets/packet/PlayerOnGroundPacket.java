package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface PlayerOnGroundPacket extends Packet {
    boolean isOnGround();
}
