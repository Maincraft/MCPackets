package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.EntityEquipmentPacket;

public class EntityEquipmentPacketImpl extends AbstractPacket implements EntityEquipmentPacket {
    private final int entityId;
    private final short slot;
    private final short itemId;
    private final short dataValue;

    public EntityEquipmentPacketImpl(int entityId, short slot, short itemId, short dataValue) {
        super();
        this.entityId = entityId;
        this.slot = slot;
        this.itemId = itemId;
        this.dataValue = dataValue;
    }

    @Override
    public int getOpcode() {
        return 0x05;
    }

    @Override
    public int getEntityId() {
        return entityId;
    }

    @Override
    public short getSlot() {
        return slot;
    }

    @Override
    public short getItemId() {
        return itemId;
    }

    @Override
    public short getDataValue() {
        return dataValue;
    }

    @Override
    public String getToStringDescription() {
        return String.format("entityId=\"%d\",slot=\"%d\",itemId=\"%d\",dataValue=\"%d\"",
                entityId, slot, itemId, dataValue);
    }
}
