package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface PluginMessagePacket extends Packet {
    String getChannel();
    short getLength();
    byte[] getData();
}
