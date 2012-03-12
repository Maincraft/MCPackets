package tk.maincraft.util.mcpackets;

@Deprecated
public class IllegalPacketDataException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IllegalPacketDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
