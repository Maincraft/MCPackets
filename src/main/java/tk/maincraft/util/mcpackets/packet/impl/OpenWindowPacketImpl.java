package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.OpenWindowPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class OpenWindowPacketImpl extends AbstractPacket implements OpenWindowPacket {
    @Serialize(type = Type.BYTE, order = 0)
    private final byte windowId;
    @Serialize(type = Type.BYTE, order = 1)
    private final byte inventoryType;
    @Serialize(type = Type.STRING, order = 2)
    private final String windowTitle;
    @Serialize(type = Type.BYTE, order = 3)
    private final byte numberOfSlots;

    public OpenWindowPacketImpl(byte windowId, byte inventoryType, String windowTitle, byte numberOfSlots) {
        super();
        this.windowId = windowId;
        this.inventoryType = inventoryType;
        this.windowTitle = windowTitle;
        this.numberOfSlots = numberOfSlots;
    }

    @Override
    public int getOpcode() {
        return 0x64;
    }

    @Override
    public byte getWindowId() {
        return windowId;
    }

    @Override
    public byte getInventoryType() {
        return inventoryType;
    }

    @Override
    public String getWindowTitle() {
        return windowTitle;
    }

    @Override
    public byte getNumberOfSlots() {
        return numberOfSlots;
    }

    @Override
    public String getToStringDescription() {
        return String.format("windowId=\"%d\",inventoryType=\"%d\",windowTitle=\"%s\",numberOfSlots=\"%d\"",
                windowId, inventoryType, windowTitle, numberOfSlots);
    }
}
