package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface SpawnObjectPacket extends Packet {
    int getEntityId();
    byte getType();
    int getX();
    int getY();
    int getZ();
    int getFireballThrower();
    short getFireballSpeedX();
    short getFireballSpeedY();
    short getFireballSpeedZ();
}
