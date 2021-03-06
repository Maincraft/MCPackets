package tk.maincraft.util.mcpackets;

import java.io.DataInput;
import java.io.IOException;
import java.net.SocketTimeoutException;

import tk.maincraft.util.mcpackets.serialization.SerializationPacketHandler;

@SuppressWarnings({ "rawtypes", "unchecked" })
public final class PacketReader {
    private PacketReader() {
    }

    private static PacketHandler handler = new SerializationPacketHandler<Packet>();

    public static Packet read(DataInput stream) throws IOException, UnknownPacketException {
        int opcode;
        try {
            opcode = stream.readUnsignedByte();
        } catch (SocketTimeoutException e) {
            return null;
        }

        if (opcode == -1) {
            // disconnected...?
            return null;
        }

        return handler.handle(stream, Packets.lookupPacket(opcode));
    }
}
