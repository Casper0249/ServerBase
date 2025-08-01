package nl.casperlambers.serverbase.chat.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import nl.casperlambers.serverbase.chat.*;
import nl.casperlambers.serverbase.chat.ServerChat;
import nl.casperlambers.serverbase.chat.types.ChatChannel;
import nl.casperlambers.serverbase.chat.types.GuildJoinPolicy;
import nl.casperlambers.serverbase.chat.types.GuildRank;
import nl.casperlambers.serverbase.chat.types.SocialPlayer;
import nl.casperlambers.serverbase.core.api.ErrorMessage;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {
    private final ServerChat serverChat = ChatMain.getPlugin(ChatMain.class).getChat();

    // SO naar chatgpt
    private String formatDayAndTime(World world) {
        long gameTime = world.getGameTime();
        long timeOfDay = world.getTime();

        long day = gameTime / 24000;

        int hours = (int) ((timeOfDay / 1000 + 6) % 24); // Shift so 0 ticks = 6:00
        int minutes = (int) ((timeOfDay % 1000) * 60 / 1000);

        return String.format("Day %d, %02d:%02d", day, hours, minutes);
    }

    @EventHandler
    public void joinEvent(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        SocialPlayer socialPlayer;

        serverChat.getSocialPlayerHashMap().put(player, new SocialPlayer()); // Create new social player
        socialPlayer = serverChat.getSocialPlayerHashMap().get(player); // Set local social player variable
        socialPlayer.setCurrentChannel(ChatChannel.GENERAL); // Set current channel to general

        final TextComponent[] joinMessage = {
                Component.text("Welcome, ", NamedTextColor.WHITE).append(Component.text(player.getName(), NamedTextColor.AQUA)).append(Component.text("!", NamedTextColor.WHITE)),
                Component.text("Type, ", NamedTextColor.WHITE).append(Component.text("/help", NamedTextColor.AQUA)).append(Component.text(" for a list of commands", NamedTextColor.WHITE)),
                Component.text("Type, ", NamedTextColor.WHITE).append(Component.text("/list", NamedTextColor.AQUA)).append(Component.text(" to see who else is online", NamedTextColor.WHITE)),
                Component.text("Players online: ", NamedTextColor.WHITE).append(Component.text(player.getServer().getOnlinePlayers().size(), NamedTextColor.AQUA)).append(Component.text(" - Server time: ", NamedTextColor.WHITE)).append(Component.text(formatDayAndTime(player.getWorld()), NamedTextColor.AQUA))
        };
        for (TextComponent currentLine : joinMessage) {
            player.sendMessage(currentLine);
        }

        // mail
        if (!socialPlayer.getMail().isEmpty()) {
            player.sendMessage("Je hebt mail! Doe /mail");
            SocialPlayer socialPlayer1 = serverChat.getSocialPlayerHashMap().get(player);
            if (socialPlayer1.getGuild().getJoinPolicy() == GuildJoinPolicy.OPEN)
        }
    }
}
