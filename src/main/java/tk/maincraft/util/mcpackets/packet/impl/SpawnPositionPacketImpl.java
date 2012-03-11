package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.SpawnPositionPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class SpawnPositionPacketImpl extends AbstractPacket implements SpawnPositionPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int x;
    @Serialize(type = Type.INT, order = 1)
    private final int y;
    @Serialize(type = Type.INT, order = 2)
    private final int z;

    public SpawnPositionPacketImpl(int x, int y, int z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int getOpcode() {
        return 6;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public String getToStringDescription() {
        return String.format("x=\"%d\",y=\"%d\",z=\"%d\"", x, y, z);
    }
}
