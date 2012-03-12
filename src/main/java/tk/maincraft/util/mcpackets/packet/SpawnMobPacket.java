package tk.maincraft.util.mcpackets.packet;

import java.util.Map;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.misc.EntityMetadata;

public interface SpawnMobPacket extends Packet {
    int getEntityId();
    byte getEntityType();
    int getX();
    int getY();
    int getZ();
    byte getYaw();
    byte getPitch();
    byte getHeadYaw();
    Map<Integer, EntityMetadata<?>> getMetadata();
}
