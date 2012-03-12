package tk.maincraft.util.mcpackets.misc;

// these MIGHT be relative
public class BlockCoords {
    private final int x;
    private final int y;
    private final int z;

    public BlockCoords(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
