package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface EntityActionPacket extends Packet {
    int getEntityId();
    byte getActionId();
}
