package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.SoundOrParticleEffectPacket;
import tk.maincraft.util.mcpackets.serialization.Type;
import tk.maincraft.util.mcpackets.serialization.Serialize;

public class SoundOrParticleEffectPacketImpl extends AbstractPacket implements
        SoundOrParticleEffectPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int effectId;
    @Serialize(type = Type.INT, order = 1)
    private final int x;
    @Serialize(type = Type.BYTE, order = 2)
    private final byte y;
    @Serialize(type = Type.INT, order = 3)
    private final int z;
    @Serialize(type = Type.INT, order = 4)
    private final int data;

    public SoundOrParticleEffectPacketImpl(int effectId, int x, byte y, int z, int data) {
        super();
        this.effectId = effectId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.data = data;
    }

    @Override
    public int getOpcode() {
        return 0x3D;
    }

    @Override
    public int getEffectId() {
        return effectId;
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
    public int getData() {
        return data;
    }

    @Override
    public String getToStringDescription() {
        return String.format("effectId=\"%d\",x=\"%d\",y=\"%d\",z=\"%d\",data=\"%d\"",
                effectId, x, y, z, data);
    }
}
