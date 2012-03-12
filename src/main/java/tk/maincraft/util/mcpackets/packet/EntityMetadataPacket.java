package tk.maincraft.util.mcpackets.packet;

import java.util.Map;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.misc.EntityMetadata;

public interface EntityMetadataPacket extends Packet {
    int getEntityId();
    Map<Integer, EntityMetadata<?>> getMetadata();
}
