package tk.maincraft.util.mcpackets.serialization;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import tk.maincraft.util.mcpackets.NetUtils;

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
            return NetUtils.readString(in, 100);
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
            byte[] bytes = new byte[(Integer) moreInfo];
            in.readFully(bytes);
            return bytes;
        }

        @Override
        public void write(DataOutput out, byte[] val) throws IOException {
            out.write(val);
        }

        @Override
        public Class<byte[]> getClazz() {
            return byte[].class;
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
    });

    private final Serializor<?> serializor;

    Type(Serializor<?> serializor) {
        this.serializor = serializor;
    }

    public Serializor<?> getSerializor() {
        return serializor;
    }
}
