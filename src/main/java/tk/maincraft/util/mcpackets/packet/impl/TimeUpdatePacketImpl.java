package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.TimeUpdatePacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class TimeUpdatePacketImpl extends AbstractPacket implements TimeUpdatePacket {
    @Serialize(type = Type.LONG, order = 0)
    private final long time;

    public TimeUpdatePacketImpl(long time) {
        super();
        this.time = time;
    }

    @Override
    public int getOpcode() {
        return 0x04;
    }

    @Override
    public long getTime() {
        return time;
    }

    @Override
    public String getToStringDescription() {
        return String.format("time=\"%d\"", time);
    }
}
