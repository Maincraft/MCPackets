package tk.maincraft.util.mcpackets;

public final class RotationUtils {
    private RotationUtils() {
    }

    public static byte floatToByte(float old) {
        return (byte) (int) ((old * 256F) / 360F);
    }

    public static float byteToFloat(byte old) {
        return (old * 360) / 256F;
    }
}
