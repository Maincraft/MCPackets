package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface EntityHeadLookPacket extends Packet {
    int getEntityId();
    byte getHeadYaw();
}
