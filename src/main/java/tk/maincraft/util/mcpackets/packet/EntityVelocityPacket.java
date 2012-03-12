package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface EntityVelocityPacket extends Packet {
    int getEntityId();
    short getVelocityX();
    short getVelocityY();
    short getVelocityZ();
}
