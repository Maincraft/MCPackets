package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface EntityRelMovePacket extends Packet {
    int getEntityId();

    byte getDiffX();

    byte getDiffY();

    byte getDiffZ();
}
