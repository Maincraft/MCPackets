package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.CloseWindowPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class CloseWindowPacketImpl extends AbstractPacket implements CloseWindowPacket {
    @Serialize(type = Type.BYTE, order = 0)
    private final byte windowId;

    public CloseWindowPacketImpl(byte windowId) {
        super();
        this.windowId = windowId;
    }

    @Override
    public int getOpcode() {
        return 0x65;
    }

    @Override
    public byte getWindowId() {
        return windowId;
    }

    @Override
    public String getToStringDescription() {
        return String.format("windowId=\"%d\"", windowId);
    }
}
