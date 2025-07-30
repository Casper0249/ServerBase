package nl.casperlambers.serverbase.chat;

import nl.casperlambers.serverbase.chat.types.ChatChannel;
import nl.casperlambers.serverbase.chat.types.Guild;
import nl.casperlambers.serverbase.chat.types.SocialPlayer;
import org.bukkit.entity.Player;

import java.util.*;

public class ServerChat {
    // Chat channels
    private final Map<ChatChannel, ArrayList<Player>> channelMuteMap = new HashMap<>();

    public ServerChat() { // Constructor
        channelMuteMap.put(ChatChannel.GENERAL, new ArrayList<>());
        channelMuteMap.put(ChatChannel.LOCAL, new ArrayList<>());
        channelMuteMap.put(ChatChannel.GUILD, new ArrayList<>());
    }

    public Map<ChatChannel, ArrayList<Player>> getChannelMuteMap()  {
        return channelMuteMap;
    }

    // Guilds
    private final HashMap<String, Guild> guildHashMap = new HashMap<>();

    public HashMap<String, Guild> getGuildHashMap() {
        return guildHashMap;
    }

    // Social players
    private final HashMap<Player, SocialPlayer> socialPlayerHashMap = new HashMap<>();

    public HashMap<Player, SocialPlayer> getSocialPlayerHashMap() {
        return socialPlayerHashMap;
    }
}
