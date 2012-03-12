package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface UseEntityPacket extends Packet {
    int getPlayerEntityId();
    int getTargetEntityId();
    boolean getIsLeftClick();
}
