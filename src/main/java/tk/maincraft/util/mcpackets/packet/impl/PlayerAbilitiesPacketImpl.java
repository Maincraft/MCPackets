package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.PlayerAbilitiesPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class PlayerAbilitiesPacketImpl extends AbstractPacket implements PlayerAbilitiesPacket {
    @Serialize(type = Type.BOOL, order = 0)
    private final boolean invulnerability;
    @Serialize(type = Type.BOOL, order = 1)
    private final boolean isFlying;
    @Serialize(type = Type.BOOL, order = 2)
    private final boolean canFly;
    @Serialize(type = Type.BOOL, order = 3)
    private final boolean instantDestroy;

    public PlayerAbilitiesPacketImpl(boolean invulnerability, boolean isFlying, boolean canFly, boolean instantDestroy) {
        super();
        this.invulnerability = invulnerability;
        this.isFlying = isFlying;
        this.canFly = canFly;
        this.instantDestroy = instantDestroy;
    }

    @Override
    public int getOpcode() {
        return 0xCA;
    }

    @Override
    public boolean getInvulnerability() {
        return invulnerability;
    }

    @Override
    public boolean getIsFlying() {
        return isFlying;
    }

    @Override
    public boolean getCanFly() {
        return canFly;
    }

    @Override
    public boolean getInstantDestroy() {
        return instantDestroy;
    }

    @Override
    public String getToStringDescription() {
        return String.format("invulnerability=\"%b\",isFlying=\"%b\",canFly=\"%b\",instantDestory=\"%b\"",
                invulnerability, isFlying, canFly, instantDestroy);
    }
}
