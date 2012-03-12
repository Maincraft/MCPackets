package tk.maincraft.util.mcpackets.packet.impl;

import java.util.Map;

import tk.maincraft.util.mcpackets.misc.EntityMetadata;
import tk.maincraft.util.mcpackets.packet.EntityMetadataPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class EntityMetadataPacketImpl extends AbstractPacket implements EntityMetadataPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int entityId;
    @Serialize(type = Type.ENTITY_METADATA, order = 1)
    private final Map<Integer, EntityMetadata<?>> metadata;

    public EntityMetadataPacketImpl(int entityId, Map<Integer, EntityMetadata<?>> metadata) {
        super();
        this.entityId = entityId;
        this.metadata = metadata;
    }

    @Override
    public int getOpcode() {
        return 0x28;
    }

    @Override
    public int getEntityId() {
        return entityId;
    }

    @Override
    public Map<Integer, EntityMetadata<?>> getMetadata() {
        return metadata;
    }

    @Override
    public String getToStringDescription() {
        return String.format("entityId=\"%d\",metadata=\"%s\"", entityId, metadata);
    }
}
