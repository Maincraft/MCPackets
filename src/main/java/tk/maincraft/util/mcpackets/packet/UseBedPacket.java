package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface UseBedPacket extends Packet {
    int getEntityId();
    byte getUnknown_byte_0();
    // coords seem to be the bed-headboard
    int getX();
    byte getY();
    int getZ();
}
