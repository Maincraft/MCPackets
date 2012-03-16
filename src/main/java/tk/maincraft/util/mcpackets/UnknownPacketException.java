package tk.maincraft.util.mcpackets;

import java.io.IOException;

public class UnknownPacketException extends IOException {
    private static final long serialVersionUID = 1L;

    public UnknownPacketException(int code) {
        super(createMessage(code));
    }

    public UnknownPacketException(int code, Throwable cause) {
        super(createMessage(code), cause);
    }

    private static String createMessage(int code) {
        return String.format("Couldn't find packet %1$d (0x0%1$X)", code);
    }
}
