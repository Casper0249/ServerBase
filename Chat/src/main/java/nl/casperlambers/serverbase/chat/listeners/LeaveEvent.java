package nl.casperlambers.serverbase.chat.listeners;

import nl.casperlambers.serverbase.chat.ChatMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        ChatMain.getPlugin(ChatMain.class).getChat().getPlayerChannelMap().remove(event.getPlayer().getUniqueId());
    }
}
