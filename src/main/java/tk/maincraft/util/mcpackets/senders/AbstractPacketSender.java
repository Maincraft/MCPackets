package tk.maincraft.util.mcpackets.senders;

import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.PacketSender;
import tk.maincraft.util.mcpackets.UnexpectedSocketIOException;

public abstract class AbstractPacketSender<T extends Packet> implements PacketSender<T> {
    @Override
    public void send(DataOutput stream, T packet) {
        try {
            stream.write(packet.getOpcode());
            sendData(stream, packet);
        } catch (IOException e) {
            throw new UnexpectedSocketIOException(String.format(
                    "Error while trying to send packet %1$d (0x0%1$X) to client!",
                    packet.getOpcode()), e);
        }
    }

    public abstract void sendData(DataOutput stream, T packet) throws IOException;
}
