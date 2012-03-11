package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.ChatPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class ChatPacketImpl extends AbstractPacket implements ChatPacket {
    @Serialize(type = Type.STRING, order = 0)
    private final String message;

    public ChatPacketImpl(String message) {
        super();
        this.message = message;
    }

    @Override
    public int getOpcode() {
        return 3;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getToStringDescription() {
        return String.format("message=\"%s\"", message);
    }
}
