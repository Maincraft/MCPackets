package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.UpdateHealthPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class UpdateHealthPacketImpl extends AbstractPacket implements UpdateHealthPacket {
    @Serialize(type = Type.SHORT, order = 0)
    private final short health;
    @Serialize(type = Type.SHORT, order = 1)
    private final short food;
    @Serialize(type = Type.FLOAT, order = 2)
    private final float saturation;

    public UpdateHealthPacketImpl(short health, short food, float saturation) {
        super();
        this.health = health;
        this.food = food;
        this.saturation = saturation;
    }
    
    @Override
    public int getOpcode() {
        return 0x08;
    }

    @Override
    public short getHealth() {
        return health;
    }

    @Override
    public short getFood() {
        return food;
    }

    @Override
    public float getSaturation() {
        return saturation;
    }

    @Override
    public String getToStringDescription() {
        return String.format("health=\"%d\",food=\"%d\",saturation=\"%d\"", health, food, saturation);
    }
}
