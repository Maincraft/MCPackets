package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.HandshakePacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class HandshakePacketImpl extends AbstractPacket implements HandshakePacket {
    @Serialize(type = Type.STRING, order = 0)
    private final String messageOrUsername;

    public HandshakePacketImpl(String messageOrName) {
        super();
        this.messageOrUsername = messageOrName;
    }

    @Override
    public String getMessageOrUsername() {
        return messageOrUsername;
    }

    @Override
    public int getOpcode() {
        return 2;
    }

    @Override
    public String getToStringDescription() {
        return String.format("message=\"%s\"", messageOrUsername);
    }
}
