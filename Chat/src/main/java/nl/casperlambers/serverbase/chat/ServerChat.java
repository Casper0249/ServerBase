package nl.casperlambers.serverbase.chat;

import org.bukkit.entity.Player;

import java.util.*;

public class ServerChat {
    private final Map<UUID, ChatChannel> playerChannelMap = new HashMap<>();
    private final Map<ChatChannel, ArrayList<Player>> channelMuteMap = new HashMap<>();

    public ServerChat() { // Constructor
        channelMuteMap.put(ChatChannel.GENERAL, new ArrayList<>());
        channelMuteMap.put(ChatChannel.LOCAL, new ArrayList<>());
        channelMuteMap.put(ChatChannel.GUILD, new ArrayList<>());
    }

    public Map<UUID, ChatChannel> getPlayerChannelMap() {
        return playerChannelMap;
    }

    public Map<ChatChannel, ArrayList<Player>> getChannelMuteMap() {
        return channelMuteMap;
    }
}
