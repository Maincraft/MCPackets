package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.PreChunkPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class PreChunkPacketImpl extends AbstractPacket implements PreChunkPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int x;
    @Serialize(type = Type.INT, order = 1)
    private final int z;
    @Serialize(type = Type.BOOL, order = 2)
    private final boolean mode;

    public PreChunkPacketImpl(int x, int z, boolean mode) {
        super();
        this.x = x;
        this.z = z;
        this.mode = mode;
    }

    @Override
    public int getOpcode() {
        return 0x32;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public boolean getMode() {
        return mode;
    }

    @Override
    public String getToStringDescription() {
        return String.format("x=\"%d\",z=\"%d\",mode=\"%b\"", x, z, mode);
    }
}
