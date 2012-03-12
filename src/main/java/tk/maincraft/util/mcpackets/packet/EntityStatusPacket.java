package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface EntityStatusPacket extends Packet {
    int getEntityId();
    byte getStatus();
}
