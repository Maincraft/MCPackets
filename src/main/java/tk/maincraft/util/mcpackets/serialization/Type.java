package tk.maincraft.util.mcpackets.serialization;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import tk.maincraft.util.mcpackets.NetUtils;
import tk.maincraft.util.mcpackets.misc.*;

public enum Type {
    INT(new Serializor<Integer>() {
        @Override
        public Integer read(DataInput in) throws IOException {
            return in.readInt();
        }

        @Override
        public void write(DataOutput out, Integer val) throws IOException {
            out.writeInt(val);
        }
    }),
    BYTE(new Serializor<Byte>() {
        @Override
        public Byte read(DataInput in) throws IOException {
            return in.readByte();
        }

        @Override
        public void write(DataOutput out, Byte val) throws IOException {
            out.writeByte(val);
        }
    }),
    UNSIGNED_BYTE(new Serializor<Integer>() {
        @Override
        public Integer read(DataInput in) throws IOException {
            return in.readUnsignedByte();
        }

        @Override
        public void write(DataOutput out, Integer val) throws IOException {
            out.writeByte(val);
        }
    }),
    BOOL(new Serializor<Boolean>() {
        @Override
        public Boolean read(DataInput in) throws IOException {
            return in.readBoolean();
        }

        @Override
        public void write(DataOutput out, Boolean val) throws IOException {
            out.writeBoolean(val);
        }
    }),
    STRING(new Serializor<String>() {
        @Override
        public String read(DataInput in) throws IOException {
            return NetUtils.readString(in, 1000);
        }

        @Override
        public void write(DataOutput out, String val) throws IOException {
            NetUtils.writeString(out, val);
        }
    }),
    SHORT(new Serializor<Short>() {
        @Override
        public Short read(DataInput in) throws IOException {
            return in.readShort();
        }

        @Override
        public void write(DataOutput out, Short val) throws IOException {
            out.writeShort(val);
        }
    }),
    UNSIGNED_SHORT(new Serializor<Integer>() {
        @Override
        public Integer read(DataInput in) throws IOException {
            return in.readUnsignedShort();
        }

        @Override
        public void write(DataOutput out, Integer val) throws IOException {
            out.writeShort(val);
        }
    }),
    BYTE_ARRAY(new ObjectUsingSerializor<byte[]>() {
        @Override
        public byte[] read(DataInput in, Object moreInfo) throws IOException {
            byte[] bytes = new byte[((Number) moreInfo).intValue()];
            in.readFully(bytes);
            return bytes;
        }

        @Override
        public void write(DataOutput out, byte[] val) throws IOException {
            out.write(val);
        }
    }),
    FLOAT(new Serializor<Float>() {
        @Override
        public Float read(DataInput in) throws IOException {
            return in.readFloat();
        }

        @Override
        public void write(DataOutput out, Float val) throws IOException {
            out.writeFloat(val);
        }
    }),
    DOUBLE(new Serializor<Double>() {
        @Override
        public Double read(DataInput in) throws IOException {
            return in.readDouble();
        }

        @Override
        public void write(DataOutput out, Double val) throws IOException {
            out.writeDouble(val);
        }
    }),
    LONG(new Serializor<Long>() {
        @Override
        public Long read(DataInput in) throws IOException {
            return in.readLong();
        }

        @Override
        public void write(DataOutput out, Long val) throws IOException {
            out.writeLong(val);
        }
    }),
    ENTITY_METADATA(new Serializor<Map<Integer, EntityMetadata<?>>>() {
        @Override
        public Map<Integer, EntityMetadata<?>> read(DataInput in) throws IOException {
            Map<Integer, EntityMetadata<?>> data = new LinkedHashMap<Integer, EntityMetadata<?>>();
            for (int x = in.readUnsignedByte(); x != 127; x = in.readUnsignedByte()) {
                int index = x & 0x1F;
                int type = x >> 5;
                MetadataType metaType = MetadataType.fromId(type);
                switch (metaType) {
                case BYTE:
                    data.put(index, new GenericMetadata<Byte>(in.readByte(), metaType));
                    break;
                case SHORT:
                    data.put(index, new GenericMetadata<Short>(in.readShort(), metaType));
                    break;
                case INT:
                    data.put(index, new GenericMetadata<Integer>(in.readInt(), metaType));
                    break;
                case FLOAT:
                    data.put(index, new GenericMetadata<Float>(in.readFloat(), metaType));
                    break;
                case STRING:
                    data.put(index, new GenericMetadata<String>(NetUtils.readString(in, 1000), metaType));
                    break;
                case ITEM:
                    short id = in.readShort();
                    byte count = in.readByte();
                    short damage = in.readShort();
                    data.put(index, new GenericMetadata<ItemStack>(new ItemStack(id, count, damage), metaType));
                    break;
                default:
                    throw new UnsupportedOperationException("Metadata-type '" + metaType + "' is not implemented!");
                }
            }
            return data;
        }

        @Override
        public void write(DataOutput out, Map<Integer, EntityMetadata<?>> val) throws IOException {
            for (Map.Entry<Integer, EntityMetadata<?>> entry : val.entrySet()) {
                int index = entry.getKey();
                MetadataType metaType = entry.getValue().getType();
                int type = metaType.getId();
                int x = (type << 5) | (index & 0x1F);
                out.writeByte(x);
                switch (metaType) {
                case BYTE:
                    out.writeByte((Byte) entry.getValue().getValue());
                    break;
                case SHORT:
                    out.writeShort((Short) entry.getValue().getValue());
                    break;
                case INT:
                    out.writeInt((Integer) entry.getValue().getValue());
                    break;
                case FLOAT:
                    out.writeFloat((Float) entry.getValue().getValue());
                    break;
                case STRING:
                    NetUtils.writeString(out, (String) entry.getValue().getValue());
                    break;
                case ITEM:
                    ItemStack item = (ItemStack) entry.getValue().getValue();
                    out.writeShort(item.getId());
                    out.writeByte(item.getStackSize());
                    out.writeShort(item.getDataValue());
                    break;
                default:
                    throw new UnsupportedOperationException("Metadata-type '" + metaType + "' is not implemented!");
                }
            }
            out.writeByte(127);
        }
    }),
    ITEMSTACK(new Serializor<ItemStack>() {
        @Override
        public ItemStack read(DataInput in) throws IOException {
            short id = in.readShort();
            if (id < 0) {
                return ItemStack.NULL_ITEMSTACK;
            } else {
                byte stackSize = in.readByte();
                short dataValue = in.readShort();
                byte[] metadata = new byte[0];
                if (isEnchantable(id)) {
                    short metadataLength = in.readShort();
                    if (metadataLength > 0) {
                        metadata = new byte[metadataLength];
                        in.readFully(metadata);
                    }
                }
                return new ItemStack(id, stackSize, dataValue, metadata);
            }
        }

        @Override
        public void write(DataOutput out, ItemStack val) throws IOException {
            if (val == ItemStack.NULL_ITEMSTACK) {
                out.writeShort(-1);
            } else {
                out.writeShort(val.getId());
                out.writeByte(val.getStackSize());
                out.writeShort(val.getDataValue());
                if (isEnchantable(val.getId())) {
                    byte[] metadata = val.getMetadata();
                    if (metadata.length == 0) {
                        out.writeShort(-1);
                    } else {
                        out.writeShort(metadata.length);
                        out.write(metadata);
                    }
                }
            }
        }
    }),
    @SuppressWarnings({ "unchecked", "rawtypes" })
    ITEMSTACK_ARRAY(new ObjectUsingSerializor<ItemStack[]>() {
        @Override
        public ItemStack[] read(DataInput in, Object more) throws IOException {
            int count = ((Number) more).intValue();
            ItemStack[] items = new ItemStack[count];
            Serializor<ItemStack> itemstackSerializor = (Serializor<ItemStack>) ITEMSTACK.getSerializor();
            for (int i = 0; i < count; i++) {
                items[i] = itemstackSerializor.read(in);
            }
            return items;
        }

        @Override
        public void write(DataOutput out, ItemStack[] val) throws IOException {
            Serializor itemstackSerializor = ITEMSTACK.getSerializor();
            for (int i = 0; i < val.length; i++) {
                itemstackSerializor.write(out, val[i]);
            }
        }
    }),
    CONDITIONAL_SHORT(new ObjectUsingSerializor<Short>() {
        /*
         * ugly hack, but I don't see a better solution :/
         */
        @Override
        public Short read(DataInput in, Object moreInfo) throws IOException {
            if (((Number) moreInfo).intValue() > 0) {
                return in.readShort();
            } else {
                return Short.MIN_VALUE;
            }
        }
        @Override
        public void write(DataOutput out, Short val) throws IOException {
            if (val != Short.MIN_VALUE)
                out.writeShort(val);
        }
    }),
    BLOCKCOORD_COLLECTION(new Serializor<Collection<BlockCoords>>() {
        @Override
        public Collection<BlockCoords> read(DataInput in) throws IOException {
            int size = in.readInt();
            Set<BlockCoords> ret = new HashSet<BlockCoords>();
            for (int i = 0; i < size; i++) {
                int x = in.readByte();
                int y = in.readByte();
                int z = in.readByte();
                ret.add(new BlockCoords(x, y, z));
            }
            return ret;
        }

        @Override
        public void write(DataOutput out, Collection<BlockCoords> val) throws IOException {
            out.writeInt(val.size());
            for (BlockCoords block : val) {
                out.writeByte(block.getX());
                out.writeByte(block.getY());
                out.writeByte(block.getZ());
            }
        }
    });

    private static final int[] ENCHANTABLE_ITEMS = {
        // see http://wiki.vg/Slot_Data#Enchantable_items
        0x103, 0x105, 0x15A, 0x167, // flint'n'steel, bow, fishingRod, shears
        // TOOLS
        // sword, shovel, pickaxe, axe, hoe
        0x10C, 0x10D, 0x10E, 0x10F, 0x122, // WOOD
        0x110, 0x111, 0x112, 0x113, 0x123, // STONE
        0x10B, 0x100, 0x101, 0x102, 0x124, // IRON
        0x114, 0x115, 0x116, 0x117, 0x125, // DIAMOND
        0x11B, 0x11C, 0x11D, 0x11E, 0x126, // GOLD
        // ARMOUR
        // helmet, chestplate, leggings, boots
        0x12A, 0x12B, 0x12C, 0x12D, // LEATHER
        0x12E, 0x12F, 0x130, 0x131, // CHAIN
        0x132, 0x133, 0x134, 0x135, // IRON
        0x136, 0x137, 0x138, 0x139, // DIAMOND
        0x13A, 0x13B, 0x13C, 0x13D  // GOLD
    };

    private static boolean isEnchantable(int id) {
        for (int i = 0; i < ENCHANTABLE_ITEMS.length; i++) {
            if (ENCHANTABLE_ITEMS[i] == id)
                return true;
        }
        return false;
    }

    private final Serializor<?> serializor;

    Type(Serializor<?> serializor) {
        this.serializor = serializor;
    }

    public Serializor<?> getSerializor() {
        return serializor;
    }
}
