package tk.maincraft.util.mcpackets.handlers;

import java.io.DataInput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.IllegalPacketDataException;
import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.PacketHandler;

public abstract class AbstractPacketHandler<T extends Packet> implements PacketHandler<T> {
    @Override
    public T handle(DataInput stream, Class<T> packetType) {
        try {
            return doRead(stream);
        } catch (IOException e) {
            throw new IllegalPacketDataException(
                    "An exception occured while trying to read a packet!", e);
        }
    }

    public abstract T doRead(DataInput stream) throws IOException;
}
