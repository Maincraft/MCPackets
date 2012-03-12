package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface SpawnPaintingPacket extends Packet {
    int getEntityId();
    String getTitle(); // stringly typed programming, mojang! :/
    int getX();
    int getY();
    int getZ();
    int getDirection();
}
