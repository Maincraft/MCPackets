package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface SoundOrParticleEffectPacket extends Packet {
    int getEffectId();
    int getX();
    byte getY();
    int getZ();
    int getData();
}
