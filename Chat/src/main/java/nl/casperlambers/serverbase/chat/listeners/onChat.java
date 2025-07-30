package nl.casperlambers.serverbase.chat.listeners;

import nl.casperlambers.serverbase.chat.ServerChat;
import nl.casperlambers.serverbase.chat.types.ChatChannel;
import nl.casperlambers.serverbase.chat.ChatMain;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onChat implements Listener {
    private final ServerChat serverChat = ChatMain.getPlugin(ChatMain.class).getChat();

    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        final ChatChannel chatChannel = serverChat.getSocialPlayerHashMap().get(event.getPlayer()).getCurrentChannel();

        // Set chat format
        final String format = Color.AQUA + player.getName() + Color.GRAY + " > " + Color.AQUA + chatChannel.getChannelName() + Color.GRAY + ": \"" + Color.WHITE + event.getMessage() + Color.GRAY + "\"";
        event.setFormat(format);

        // Remove muting players from recipients
        for (Player currentPlayer : serverChat.getChannelMuteMap().get(chatChannel)) { // Removes every player in the mute list from the recipients list
            event.getRecipients().remove(currentPlayer);
        }
    }
}
