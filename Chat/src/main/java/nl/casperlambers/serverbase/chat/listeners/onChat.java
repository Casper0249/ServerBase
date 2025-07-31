package nl.casperlambers.serverbase.chat.listeners;

import nl.casperlambers.serverbase.chat.ServerChat;
import nl.casperlambers.serverbase.chat.types.ChatChannel;
import nl.casperlambers.serverbase.chat.ChatMain;
import nl.casperlambers.serverbase.chat.types.SocialPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Set;

public class onChat implements Listener {
    private final ServerChat serverChat = ChatMain.getPlugin(ChatMain.class).getChat();

    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        final SocialPlayer socialPlayer = serverChat.getSocialPlayerHashMap().get(player)
        final ChatChannel chatChannel =socialPlayer.getCurrentChannel();
        final Set<Player> recipients = event.getRecipients();

        // Set chat format
        final String format = Color.AQUA + player.getName() + Color.GRAY + " > " + Color.AQUA + chatChannel.getChannelName() + Color.GRAY + ": \"" + Color.WHITE + event.getMessage() + Color.GRAY + "\"";
        event.setFormat(format);

        // Handle guild and local chat
        if (chatChannel == ChatChannel.GUILD) {
            recipients.clear();
            recipients.addAll(socialPlayer.getGuild().getMembersAll());
        } else if (chatChannel == ChatChannel.LOCAL) {
            recipients.clear();
            for (Player possibleRecipient : Bukkit.getOnlinePlayers()) {
                if (possibleRecipient.getLocation().distance(player.getLocation()) <= ChatChannel.getLocalDistanceMax()) {
                    recipients.add(possibleRecipient);
                }
            }
        }

        // Remove muting players from recipients
        for (Player currentPlayer : serverChat.getChannelMuteMap().get(chatChannel)) { // Removes every player in the mute list from the recipients list
            recipients.remove(currentPlayer);
        }
    }
}
