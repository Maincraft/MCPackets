package tk.maincraft.util.mcpackets;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import org.junit.Test;

import tk.maincraft.util.mcpackets.packet.ChatPacket;
import tk.maincraft.util.mcpackets.packet.impl.ChatPacketImpl;

public class TestSerializationPacketIO {
    @Test
    public void testPacketReader() throws Exception {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        DataOutputStream dOut = new DataOutputStream(bOut);
        dOut.write(3); // packet-ID
        NetUtils.writeString(dOut, "message!"); // data

        byte[] bytes = bOut.toByteArray();
        ByteArrayInputStream bIn = new ByteArrayInputStream(bytes);
        DataInputStream dIn = new DataInputStream(bIn);
        Packet packet = PacketReader.read(dIn);
        assertEquals(ChatPacketImpl.class, packet.getClass());
        assertEquals("message!", ((ChatPacket) packet).getMessage());
    }

    @Test
    public void testPacketWriter() throws Exception {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        DataOutputStream dOut = new DataOutputStream(bOut);

        PacketWriter.writePacket(dOut, new ChatPacketImpl("message!"));

        byte[] bytes = bOut.toByteArray();
        ByteArrayInputStream bIn = new ByteArrayInputStream(bytes);
        DataInputStream dIn = new DataInputStream(bIn);
        assertEquals(3, dIn.readByte());
        assertEquals("message!", NetUtils.readString(dIn, 100));
        assertEquals(0, dIn.available());
    }

    @Test
    public void testReadAndWrite() throws Exception {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        DataOutputStream dOut = new DataOutputStream(bOut);

        ChatPacket chatPacket = new ChatPacketImpl("message!");
        PacketWriter.writePacket(dOut, chatPacket);

        byte[] bytes = bOut.toByteArray();
        ByteArrayInputStream bIn = new ByteArrayInputStream(bytes);
        DataInputStream dIn = new DataInputStream(bIn);

        Packet readPacket = PacketReader.read(dIn);
        assertEquals(chatPacket, readPacket);
    }
}
