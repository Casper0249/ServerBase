package nl.casperlambers.serverbase.chat.listeners;

import nl.casperlambers.serverbase.chat.Chat;
import nl.casperlambers.serverbase.chat.ChatChannel;
import nl.casperlambers.serverbase.chat.ChatMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {
    private final Chat chat = ChatMain.getPlugin(ChatMain.class).getChat();

    @EventHandler
    public void joinEvent(PlayerJoinEvent event) {
        chat.getPlayerChannelMap().put(event.getPlayer().getUniqueId(), ChatChannel.GENERAL); // Puts joining players in general channel
    }
}
