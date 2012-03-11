package tk.maincraft.util.mcpackets;

import java.io.DataOutput;

public interface PacketSender<T extends Packet> {
    void send(DataOutput stream, T packet);
}
