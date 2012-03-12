package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface EntityEffectPacket extends Packet {
    int getEntityId();
    byte getEffectId();
    byte getAmplifier();
    short getDuration();
}
