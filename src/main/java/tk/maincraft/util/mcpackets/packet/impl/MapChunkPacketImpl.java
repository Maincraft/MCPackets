package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.MapChunkPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class MapChunkPacketImpl extends AbstractPacket implements MapChunkPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int x;
    @Serialize(type = Type.INT, order = 1)
    private final int z;
    @Serialize(type = Type.BOOL, order = 2)
    private final boolean groundUpContinuous;
    @Serialize(type = Type.UNSIGNED_SHORT, order = 3)
    private final int primaryBitMap;
    @Serialize(type = Type.UNSIGNED_SHORT, order = 4)
    private final int addBitMap;
    @Serialize(type = Type.INT, order = 5)
    private final int compressedSize;
    @Serialize(type = Type.INT, order = 6)
    private final int unused_int_0;
    @Serialize(type = Type.BYTE_ARRAY, order = 7, moreInfo = 5)
    private final byte[] chunkData;

    public MapChunkPacketImpl(int x, int z, boolean groundUpContinuous, int primaryBitMap, int addBitMap, byte[] chunkData) {
        this(x, z, groundUpContinuous, primaryBitMap, addBitMap, 0, chunkData);
    }

    public MapChunkPacketImpl(int x, int z, boolean groundUpContinuous, int primaryBitMap, int addBitMap, int unused_int_0, byte[] chunkData) {
        this(x, z, groundUpContinuous, primaryBitMap, addBitMap, chunkData.length, unused_int_0, chunkData);
    }

    public MapChunkPacketImpl(int x, int z, boolean groundUpContinuous, int primaryBitMap, int addBitMap, int compressedSize, int unused_int_0, byte[] chunkData) {
        super();
        this.x = x;
        this.z = z;
        this.groundUpContinuous = groundUpContinuous;
        this.primaryBitMap = primaryBitMap;
        this.addBitMap = addBitMap;
        this.compressedSize = compressedSize;
        this.unused_int_0 = unused_int_0;
        this.chunkData = chunkData;
    }

    @Override
    public int getOpcode() {
        return 0x33;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public boolean isGroundUpContinuous() {
        return groundUpContinuous;
    }

    @Override
    public int getPrimaryBitMap() {
        return primaryBitMap;
    }

    @Override
    public int getAddBitMap() {
        return addBitMap;
    }

    @Override
    public int getCompressedSize() {
        return compressedSize;
    }

    @Override
    public int getUnused_int_0() {
        return unused_int_0;
    }

    @Override
    public byte[] getCompressedChunkData() {
        return chunkData;
    }

    @Override
    public String getToStringDescription() {
        return String.format(
                "x=\"%d\",z=\"%d\",groundUpContinuous=\"%b\",primaryBitMap=\"%d\",addBitMap=\"%d\",compressedSize=\"%d\",unused_int_0=\"%d\",chunkData=byte[%d]",
                        x, z, groundUpContinuous, primaryBitMap, addBitMap, compressedSize, unused_int_0, chunkData.length);
    }
}
