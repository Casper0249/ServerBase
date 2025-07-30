package nl.casperlambers.serverbase.chat.types;

import nl.casperlambers.serverbase.chat.ChatMain;
import nl.casperlambers.serverbase.core.ServerBase;
import nl.casperlambers.serverbase.core.api.ServerBaseAPI;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SocialPlayer {
    private Guild guild;
    private ChatChannel currentChannel;
    private ArrayList<String> mail;

    public SocialPlayer() {
        //todo
    }

    public Guild getGuild() {
        return guild;
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
