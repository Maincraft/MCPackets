package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface EntityEquipmentPacket extends Packet {
    int getEntityId();
    short getSlot();
    short getItemId();
    short getDataValue();
}
