package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface AnimationPacket extends Packet {
    int getEntityId();
    byte getAnimation();
}
