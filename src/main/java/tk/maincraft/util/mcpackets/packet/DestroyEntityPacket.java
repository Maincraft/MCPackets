package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface DestroyEntityPacket extends Packet {
    int getEntityId();
}
