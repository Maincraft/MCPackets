package tk.maincraft.util.mcpackets;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.serialization.SerializationPacketSender;

public final class PacketWriter {
    private PacketWriter() {
    }

    private static PacketSender<Packet> sender = new SerializationPacketSender<Packet>();

    public static void writePacket(DataOutput out, Packet packet)
            throws UnknownPacketException, UnexpectedSocketIOException {
        try {
            out.write(packet.getOpcode());
            sender.send(out, packet);
        } catch (IOException e) {
            throw new UnexpectedSocketIOException(e);
        }
    }
}
