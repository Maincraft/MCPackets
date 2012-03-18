package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.serialization.HashcodeAndEqualsStub;

abstract class AbstractPacket extends HashcodeAndEqualsStub implements Packet {
    @Override
    public Class<? extends Packet> getPacketType() {
        return super.getInterface();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("@").append(Integer.toHexString(hashCode()));
        sb.append(String.format(" (%1$d/0x0%1$X) ", getOpcode()));
        sb.append("[").append(getToStringDescription()).append("]");
        return sb.toString();
    }

    public abstract String getToStringDescription();
}
