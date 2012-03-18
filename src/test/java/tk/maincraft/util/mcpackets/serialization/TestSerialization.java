package tk.maincraft.util.mcpackets.serialization;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;
import static tk.maincraft.util.mcpackets.serialization.SerializationHelper.*;
import static org.mockito.Mockito.verify;

import java.io.DataInput;
import java.io.DataOutput;
import org.junit.Before;
import org.junit.Test;

import tk.maincraft.util.mcpackets.Packet;
import tk.maincraft.util.mcpackets.packet.ChatPacket;
import tk.maincraft.util.mcpackets.packet.impl.ChatPacketImpl;

public class TestSerialization {
    SerializationPacketHandler<ChatPacket> handler;
    SerializationPacketSender<ChatPacket> sender;
    DataInput input;
    DataOutput output;

    @Before
    public void setUp() throws Exception {
        handler = new SerializationPacketHandler<ChatPacket>();
        sender = new SerializationPacketSender<ChatPacket>();

        input = mock(DataInput.class);
        output = mock(DataOutput.class);
    }

    @Test
    public void testGetImplClass() throws Exception {
        assertEquals(ChatPacketImpl.class, getImplClass(ChatPacket.class));
    }

    @Test
    public void testRecvWithChatPacket() throws Exception {
        when(input.readShort()).thenReturn((short) 2);
        when(input.readChar()).thenReturn('a');
        ChatPacket packet = handler.handle(input, ChatPacket.class);
        assertEquals(ChatPacketImpl.class, packet.getClass());
        assertEquals("aa", packet.getMessage());
    }

    @Test
    public void testSendWithChatPacket() throws Exception {
        ChatPacket packet = new ChatPacketImpl("msg");
        sender.send(output, packet);
        verify(output).writeShort(3);
        verify(output).writeChars("msg");
        verifyNoMoreInteractions(output);
    }

    @Test
    public void testSendWithCustomChatPacket() throws Exception {
        ChatPacket packet = new OtherChatPacket("msg");
        sender.send(output, packet);
        verify(output).writeShort(3);
        verify(output).writeChars("msg");
        verifyNoMoreInteractions(output);
    }

    @Test
    public void testToMethodName() throws Exception {
        assertEquals("getProp", toMethodName("prop"));
    }

    @Test
    public void testGetInterface() throws Exception {
        assertEquals(ChatPacket.class, getPacketInterface(ChatPacketImpl.class));
        assertEquals(ChatPacket.class, getPacketInterface(OtherChatPacket.class));
        assertEquals(ChatPacket.class, new ChatPacketImpl("").getPacketType());
        assertEquals(ChatPacket.class, new OtherChatPacket("").getPacketType());
    }

    @Test
    public void testEquals() throws Exception {
        ChatPacket originalPacket = new ChatPacketImpl("msg");
        OtherChatPacket moddedPacket = new OtherChatPacket("msg");
        assertTrue(originalPacket.equals(moddedPacket));
        moddedPacket.setMessage("other");
        assertFalse(originalPacket.equals(moddedPacket));
        moddedPacket.setMessage("msg");
        assertTrue(originalPacket.equals(moddedPacket));
    }

    private static final class OtherChatPacket implements ChatPacket {
        private String msg;

        public OtherChatPacket(String msg) {
            this.msg = msg;
        }

        @Override
        public int getOpcode() {
            return 0;
        }

        @Override
        public String getMessage() {
            return msg;
        }

        public void setMessage(String msg) {
            this.msg = msg;
        }

        @Override
        public Class<? extends Packet> getPacketType() {
            return ChatPacket.class;
        }
    }
}
