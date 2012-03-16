package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.UpdateTileEntityPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class UpdateTileEntityPacketImpl extends AbstractPacket implements UpdateTileEntityPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int x;
    @Serialize(type = Type.SHORT, order = 1)
    private final short y;
    @Serialize(type = Type.INT, order = 2)
    private final int z;
    @Serialize(type = Type.BYTE, order = 3)
    private final byte action;
    @Serialize(type = Type.INT, order = 4)
    private final int custom1;
    @Serialize(type = Type.INT, order = 5)
    private final int custom2;
    @Serialize(type = Type.INT, order = 6)
    private final int custom3;

    public UpdateTileEntityPacketImpl(int x, short y, int z, byte action, int custom1, int custom2, int custom3) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
        this.action = action;
        this.custom1 = custom1;
        this.custom2 = custom2;
        this.custom3 = custom3;
    }

    @Override
    public int getOpcode() {
        return 0x84;
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
    public byte getAction() {
        return action;
    }

    @Override
    public int getCustom1() {
        return custom1;
    }

    @Override
    public int getCustom2() {
        return custom2;
    }

    @Override
    public int getCustom3() {
        return custom3;
    }

    @Override
    public String getToStringDescription() {
        return String.format("x=\"%d\",y=\"%d\",z=\"%d\",action=\"%d\",custom1=\"%d\",custom2=\"%d\",custom3=\"%d\"",
                x, y, z, action, custom1, custom2, custom3);
    }
}
