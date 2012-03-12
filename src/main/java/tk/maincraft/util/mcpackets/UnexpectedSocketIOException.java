package tk.maincraft.util.mcpackets;

public class UnexpectedSocketIOException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnexpectedSocketIOException(int packet, Throwable cause) {
        super(String.format("Error while trying to send packet %1$d (0x0%1$X) to client!",
                packet), cause);
    }
}
