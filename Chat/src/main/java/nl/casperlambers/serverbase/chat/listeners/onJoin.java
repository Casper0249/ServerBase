package nl.casperlambers.serverbase.chat.listeners;

import nl.casperlambers.serverbase.chat.ServerChat;
import nl.casperlambers.serverbase.chat.ChatChannel;
import nl.casperlambers.serverbase.chat.ChatMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {@EventHandler
    public void joinEvent(PlayerJoinEvent event) {
        ChatMain.getPlugin(ChatMain.class).getChat().getPlayerChannelMap().put(event.getPlayer().getUniqueId(), ChatChannel.GENERAL); // Puts joining players in general channel
    }
}
