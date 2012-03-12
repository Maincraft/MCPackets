package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface ConfirmTransactionPacket extends Packet {
    byte getWindowId();
    short getAction();
    boolean getAccepted();
}
