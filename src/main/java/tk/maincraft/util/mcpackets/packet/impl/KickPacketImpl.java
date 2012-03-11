package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.KickPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class KickPacketImpl extends AbstractPacket implements KickPacket {
    @Serialize(type = Type.STRING, order = 0)
    private final String reason;

    public KickPacketImpl(String reason) {
        super();
        this.reason = reason;
    }

    @Override
    public int getOpcode() {
        return 255;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public String getToStringDescription() {
        return String.format("reason=\"%s\"", reason);
    }
}
