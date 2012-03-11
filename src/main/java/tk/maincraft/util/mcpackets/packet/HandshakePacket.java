package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface HandshakePacket extends Packet {
    /*
     * the client uses this slot to send "username;host:port", the server sends a connection-hash
     */
    String getMessageOrUsername();
}
