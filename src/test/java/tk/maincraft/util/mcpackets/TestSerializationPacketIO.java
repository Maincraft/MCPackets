package tk.maincraft.util.mcpackets;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
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
        DataOutput output = mock(DataOutput.class);
        PacketWriter.writePacket(output, new ChatPacketImpl("message!"));
        verify(output).write(3); // packet-ID
        verify(output).writeShort(8); // length
        verify(output).writeChars("message!");
        verifyNoMoreInteractions(output);
    }
}
