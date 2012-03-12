package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.HeldItemChangePacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class HeldItemChangePacketImpl extends AbstractPacket implements HeldItemChangePacket {
    @Serialize(type = Type.SHORT, order = 0)
    private final short slotId;

    public HeldItemChangePacketImpl(short slotId) {
        super();
        this.slotId = slotId;
    }

    @Override
    public int getOpcode() {
        return 0x10;
    }

    @Override
    public short getSlotId() {
        return slotId;
    }

    @Override
    public String getToStringDescription() {
        return String.format("slotId=\"%d\"", slotId);
    }
}
