package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.EnchantItemPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class EnchantItemPacketImpl extends AbstractPacket implements EnchantItemPacket {
    @Serialize(type = Type.BYTE, order = 0)
    private final byte windowId;
    @Serialize(type = Type.BYTE, order = 1)
    private final byte enchantment;

    public EnchantItemPacketImpl(byte windowId, byte enchantment) {
        super();
        this.windowId = windowId;
        this.enchantment = enchantment;
    }

    @Override
    public int getOpcode() {
        return 0x6C;
    }

    @Override
    public byte getWindowId() {
        return windowId;
    }

    @Override
    public byte getEnchantment() {
        return enchantment;
    }

    @Override
    public String getToStringDescription() {
        return String.format("windowId=\"%d\",enchantment=\"%d\"", windowId, enchantment);
    }
}
