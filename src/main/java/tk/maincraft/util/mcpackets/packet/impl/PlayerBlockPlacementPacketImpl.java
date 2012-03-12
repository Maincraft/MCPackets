package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.misc.ItemStack;
import tk.maincraft.util.mcpackets.packet.PlayerBlockPlacementPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class PlayerBlockPlacementPacketImpl extends AbstractPacket implements
        PlayerBlockPlacementPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int x;
    @Serialize(type = Type.BYTE, order = 1)
    private final byte y;
    @Serialize(type = Type.INT, order = 2)
    private final int z;
    @Serialize(type = Type.BYTE, order = 3)
    private final byte direction;
    @Serialize(type = Type.ITEMSTACK, order = 4)
    private final ItemStack heldItem;

    public PlayerBlockPlacementPacketImpl(int x, byte y, int z, byte action, ItemStack heldItem) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = action;
        this.heldItem = heldItem;
    }

    @Override
    public int getOpcode() {
        return 0x0F;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public byte getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public byte getDirection() {
        return direction;
    }

    @Override
    public ItemStack getHeldItem() {
        return heldItem;
    }

    @Override
    public String getToStringDescription() {
        return String.format("x=\"%d\",y=\"%d\",z=\"%d\",direction=\"%d\",heldItem=\"%s\"",
                x, y, z, direction, heldItem);
    }
}
