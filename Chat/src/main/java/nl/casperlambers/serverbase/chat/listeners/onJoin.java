package nl.casperlambers.serverbase.chat.listeners;

import nl.casperlambers.serverbase.chat.*;
import nl.casperlambers.serverbase.chat.ServerChat;
import nl.casperlambers.serverbase.chat.types.ChatChannel;
import nl.casperlambers.serverbase.chat.types.GuildJoinPolicy;
import nl.casperlambers.serverbase.chat.types.GuildRank;
import nl.casperlambers.serverbase.chat.types.SocialPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {
    private final ServerChat serverChat = ChatMain.getPlugin(ChatMain.class).getChat();
    @EventHandler
    public void joinEvent(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        SocialPlayer socialPlayer;

        serverChat.getSocialPlayerHashMap().put(player, new SocialPlayer()); // Create new social player
        socialPlayer = serverChat.getSocialPlayerHashMap().get(player); // Set local social player variable
        socialPlayer.setCurrentChannel(ChatChannel.GENERAL); // Set current channel to general

        // Join message
        player.sendMessage("Welkom homo!");

        // mail
        if (!socialPlayer.getMail().isEmpty()) {
            player.sendMessage("Je hebt mail! Doe /mail");
            SocialPlayer socialPlayer1 = serverChat.getSocialPlayerHashMap().get(player);
            if (socialPlayer1.getGuild().getJoinPolicy() == GuildJoinPolicy.OPEN)
        }

    }
}
