package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.ChangeGameStatePacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class ChangeGameStatePacketImpl extends AbstractPacket implements ChangeGameStatePacket {
    @Serialize(type = Type.BYTE, order = 0)
    private final byte reason;
    @Serialize(type = Type.BYTE, order = 1)
    private final byte gameMode;

    public ChangeGameStatePacketImpl(byte reason, byte gameMode) {
        super();
        this.reason = reason;
        this.gameMode = gameMode;
    }

    @Override
    public int getOpcode() {
        return 0x46;
    }

    @Override
    public byte getReason() {
        return reason;
    }

    @Override
    public byte getGameMode() {
        return gameMode;
    }

    @Override
    public String getToStringDescription() {
        return String.format("reason=\"%d\",gameMode=\"%d\"", reason, gameMode);
    }
}
