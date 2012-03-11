package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface EntityLookPacket extends Packet {
    int getEntityId();

    byte getYaw();

    byte getPitch();
}
