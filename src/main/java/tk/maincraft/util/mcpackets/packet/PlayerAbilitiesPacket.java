package tk.maincraft.util.mcpackets.packet;

import tk.maincraft.util.mcpackets.Packet;

public interface PlayerAbilitiesPacket extends Packet {
    boolean getInvulnerability(); // not sure
    boolean getIsFlying();
    boolean getCanFly();
    boolean getInstantDestroy(); // not sure
}
