package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface RemoveEntityEffectPacket extends Packet {
    int getEntityId();
    byte getEffectId();
}
