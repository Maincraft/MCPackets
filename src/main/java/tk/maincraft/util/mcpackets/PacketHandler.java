package tk.maincraft.util.mcpackets;

import java.io.DataInput;

public interface PacketHandler<T extends Packet> {
    T handle(DataInput in, Class<T> packetType);
}
