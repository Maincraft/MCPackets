package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface AttachEntityPacket extends Packet {
    int getEntityId();
    int getVehicleId(); // -1 for unattaching
}
