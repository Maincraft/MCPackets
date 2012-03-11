package tk.maincraft.util.mcpackets.packet.impl;

import tk.maincraft.util.mcpackets.packet.LoginPacket;
import tk.maincraft.util.mcpackets.serialization.Serialize;
import tk.maincraft.util.mcpackets.serialization.Type;

public class LoginPacketImpl extends AbstractPacket implements LoginPacket {
    @Serialize(type = Type.INT, order = 0)
    private final int protocolVersionOrEntityId;
    @Serialize(type = Type.STRING, order = 1)
    private final String username;
    @Serialize(type = Type.STRING, order = 2)
    private final String levelType;
    @Serialize(type = Type.INT, order = 3)
    private final int mode;
    @Serialize(type = Type.INT, order = 4)
    private final int dimension;
    @Serialize(type = Type.BYTE, order = 5)
    private final byte difficulty;
    @Serialize(type = Type.UNSIGNED_BYTE, order = 6)
    private final int worldHeight;
    @Serialize(type = Type.UNSIGNED_BYTE, order = 7)
    private final int maxPlayers;

    public LoginPacketImpl(int protocolVersionOrEntityId, String username, String levelType, int mode,
            int dimension, byte difficulty, int worldHeight, int maxPlayers) {
        super();
        this.protocolVersionOrEntityId = protocolVersionOrEntityId;
        this.username = username;
        this.levelType = levelType;
        this.mode = mode;
        this.dimension = dimension;
        this.difficulty = difficulty;
        this.worldHeight = worldHeight;
        this.maxPlayers = maxPlayers;
    }

    @Override
    public int getProtocolVersionOrEntityId() {
        return protocolVersionOrEntityId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getLevelType() {
        return levelType;
    }

    @Override
    public int getMode() {
        return mode;
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public byte getDifficulty() {
        return difficulty;
    }

    @Override
    public int getWorldHeight() {
        return worldHeight;
    }

    @Override
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public int getOpcode() {
        return 1;
    }

    @Override
    public String getToStringDescription() {
        return String.format("entityId=\"%d\",username=\"%s\",levelType=\"%s\"mode=\"%d\","
                + "dimension=\"%d\",difficulty=\"%d\",worldHeight=\"%d\",maxPlayers=\"%d\"",
                protocolVersionOrEntityId, username, levelType, mode, dimension, difficulty,
                worldHeight, maxPlayers);
    }
}
