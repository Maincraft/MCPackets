package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.misc.ItemStack;
import tk.maincraft.util.mcpackets.packet.CreativeInventoryActionPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class CreativeInventoryActionPacketImpl extends AbstractPacket implements
        CreativeInventoryActionPacket {
    @Serialize(type = Type.SHORT, order = 0)
    private final short slot;
    @Serialize(type = Type.ITEMSTACK, order = 0)
    private final ItemStack item;

    public CreativeInventoryActionPacketImpl(short slot, ItemStack item) {
        super();
        this.slot = slot;
        this.item = item;
    }

    @Override
    public int getOpcode() {
        return 0x6B;
    }

    @Override
    public short getSlot() {
        return slot;
    }

    @Override
    public ItemStack getItem() {
        return item;
    }

    @Override
    public String getToStringDescription() {
        return String.format("slot=\"%d\",item=\"%s\"", slot, item);
    }
}
