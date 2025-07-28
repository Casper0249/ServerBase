package nl.casperlambers.serverbase.chat.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import nl.casperlambers.serverbase.chat.Chat;
import nl.casperlambers.serverbase.chat.ChatChannel;
import nl.casperlambers.serverbase.chat.ChatMain;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jetbrains.annotations.Async;

public class onChat implements Listener {
    private final Chat chat = ChatMain.getPlugin(ChatMain.class).getChat();

    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        final ChatChannel chatChannel = chat.getPlayerChannelMap().get(player.getUniqueId());

        final String format = Color.AQUA + player.getName() + Color.GRAY + " > " + Color.AQUA + chatChannel.getChannelName() + Color.GRAY + ": \"" + Color.WHITE + event.getMessage() + Color.GRAY + "\"";
        event.setFormat(format);

        switch (chatChannel) {
            case LOCAL -> event.getRecipients()
        }

    }

    private void getLocalRecipients() {

    }
}
