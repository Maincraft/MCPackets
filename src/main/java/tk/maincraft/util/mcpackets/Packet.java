package tk.maincraft.util.mcpackets;

public interface Packet {
    int getOpcode();
    /**
     * @return The interface in {@code tk.maincraft.util.mcpackets.packet} this packet implements.
     */
    Class<? extends Packet> getPacketType();
}
