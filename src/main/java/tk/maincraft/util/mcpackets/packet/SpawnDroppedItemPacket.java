package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface SpawnDroppedItemPacket extends Packet {
    int getEntityId();
    short getItemId();
    byte getCount();
    short getDataValue();
    int getX();
    int getY();
    int getZ();
    byte getRotation();
    byte getPitch();
    byte getRoll();
}
