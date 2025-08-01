package nl.casperlambers.serverbase.chat;

import nl.casperlambers.serverbase.chat.types.ChatChannel;
import nl.casperlambers.serverbase.chat.types.Guild;
import nl.casperlambers.serverbase.chat.types.SocialPlayer;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerChat {
    private final ConcurrentHashMap<ChatChannel, CopyOnWriteArrayList<Player>> channelMuteMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Guild> guildHashMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Player, SocialPlayer> socialPlayerHashMap = new ConcurrentHashMap<>();

    public ServerChat() { // Constructor
        channelMuteMap.put(ChatChannel.GENERAL, new CopyOnWriteArrayList<>());
        channelMuteMap.put(ChatChannel.LOCAL, new CopyOnWriteArrayList<>());
        channelMuteMap.put(ChatChannel.GUILD, new CopyOnWriteArrayList<>());
    }

    public ConcurrentHashMap<ChatChannel, CopyOnWriteArrayList<Player>> getChannelMuteMap()  {
        return channelMuteMap;
    }

    public ConcurrentHashMap<String, Guild> getGuildHashMap() {
        return guildHashMap;
    }

    public ConcurrentHashMap<Player, SocialPlayer> getSocialPlayerHashMap() {
        return socialPlayerHashMap;
    }
}
