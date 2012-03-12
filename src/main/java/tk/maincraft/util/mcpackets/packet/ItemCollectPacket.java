package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface ItemCollectPacket extends Packet {
    // these are entity-ids
    int getCollected();
    int getCollector();
}
