package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.KeepAlivePacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class KeepAlivePacketImpl extends AbstractPacket implements KeepAlivePacket {
    @Serialize(type = Type.INT, order = 0)
    private final int id;

    public KeepAlivePacketImpl(int id) {
        super();
        this.id = id;
    }

    @Override
    public int getOpcode() {
        return 0;
    }

    @Override
    public int getToken() {
        return id;
    }

    @Override
    public String getToStringDescription() {
        return String.format("id=\"%d\"", id);
    }
}
