package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.IncrementStatisticPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class IncrementStatisticPacketImpl extends AbstractPacket implements
        IncrementStatisticPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int statisticId;
    @Serialize(type = Type.BYTE, order = 1)
    private final byte amount;

    public IncrementStatisticPacketImpl(int statisticId, byte amount) {
        super();
        this.statisticId = statisticId;
        this.amount = amount;
    }

    @Override
    public int getOpcode() {
        return 0xC8;
    }

    @Override
    public int getStatisticId() {
        return statisticId;
    }

    @Override
    public byte getAmount() {
        return amount;
    }

    @Override
    public String getToStringDescription() {
        return String.format("statisticId=\"%d\",amount=\"%d\"", statisticId, amount);
    }
}
