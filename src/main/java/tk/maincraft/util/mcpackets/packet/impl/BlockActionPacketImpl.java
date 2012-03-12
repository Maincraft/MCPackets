package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.BlockActionPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class BlockActionPacketImpl extends AbstractPacket implements BlockActionPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int x;
    @Serialize(type = Type.SHORT, order = 1)
    private final short y;
    @Serialize(type = Type.INT, order = 2)
    private final int z;
    @Serialize(type = Type.BYTE, order = 3)
    private final byte byte1;
    @Serialize(type = Type.BYTE, order = 4)
    private final byte byte2;

    public BlockActionPacketImpl(int x, short y, int z, byte byte1, byte byte2) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
        this.byte1 = byte1;
        this.byte2 = byte2;
    }

    @Override
    public int getOpcode() {
        return 0x36;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public short getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public byte getByte1() {
        return byte1;
    }

    @Override
    public byte getByte2() {
        return byte2;
    }

    @Override
    public String getToStringDescription() {
        return String.format("x=\"%d\",y=\"%d\",z=\"%d\",byte1=\"%d\",byte2=\"%d\"", x, y, z, byte1, byte2);
    }
}
