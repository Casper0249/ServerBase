package nl.casperlambers.serverbase.chat.types;

import nl.casperlambers.serverbase.chat.ChatMain;
import nl.casperlambers.serverbase.core.ServerBase;
import nl.casperlambers.serverbase.core.api.ServerBaseAPI;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SocialPlayer {
    private String guildName;
    private ChatChannel currentChannel;
    private ArrayList<String> mail;

    public SocialPlayer() {
        //todo get mail and guild
    }

    public Guild getGuild() {
        return ChatMain.getPlugin(ChatMain.class).getChat().getGuildHashMap().get(guildName);
    }

    public ChatChannel getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(ChatChannel currentChannel) {
        this.currentChannel = currentChannel;
    }

    public ArrayList<String> getMail() {
        return mail;
    }

}
