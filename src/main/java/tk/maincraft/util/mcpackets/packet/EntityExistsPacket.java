package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

// yay for useless packets of doom...
public interface EntityExistsPacket extends Packet {
    int getEntityId();
}
