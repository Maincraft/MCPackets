package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.EntityActionPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class EntityActionPacketImpl extends AbstractPacket implements EntityActionPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int entityId;
    @Serialize(type = Type.BYTE, order = 1)
    private final byte actionId;

    public EntityActionPacketImpl(int entityId, byte actionId) {
        super();
        this.entityId = entityId;
        this.actionId = actionId;
    }

    @Override
    public int getOpcode() {
        return 0x13;
    }

    @Override
    public int getEntityId() {
        return entityId;
    }

    @Override
    public byte getActionId() {
        return actionId;
    }

    @Override
    public String getToStringDescription() {
        return String.format("entityId=\"%d\",actionId=\"%d\"", entityId, actionId);
    }
}
