package nl.casperlambers.serverbase.core.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import nl.casperlambers.serverbase.core.api.SuggestionsUtil;
import nl.casperlambers.serverbase.core.api.message.Error;
import nl.casperlambers.serverbase.core.api.message.Info;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public class Command_smite {
    public static LiteralArgumentBuilder<CommandSourceStack> literalArgumentBuilder() {
        return Commands.literal("smite")
                .requires(commandSourceStack -> commandSourceStack.getSender().hasPermission("serverbase.core.smite"))
                .executes(Command_smite::noArgSmite)
                .then(Commands.argument("targets", StringArgumentType.greedyString())
                        .suggests(SuggestionsUtil::suggestOnlinePlayersGreedy)
                        .executes(Command_smite::smitePlayers)
                );
    }

    public static CompletableFuture<Suggestions> getPlayerSuggestions(final CommandContext<CommandSourceStack> context, final SuggestionsBuilder builder) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            builder.suggest(player.getName());
        }
        return builder.buildFuture();
    }

    private static int smitePlayers(CommandContext<CommandSourceStack> context) {
        final CommandSender sender = context.getSource().getSender();
        int smittenPlayers = 0;
        String[] names = context.getArgument("targets", String.class).trim().split("\\s+");

        for (String name : names) {
            final Player player = Bukkit.getPlayer(name);
            if (player == null) {
                sender.sendMessage(Error.PLAYER_OFFLINE.format(name));
                continue;
            }
            player.getWorld().strikeLightning(player.getLocation());
            sender.sendMessage(Info.OBJECT_INTERACT.format("Player", name, "smitten!"));
            smittenPlayers++;
        }

        return smittenPlayers;
    }

    private static int noArgSmite(CommandContext<CommandSourceStack> context) {
        final CommandSender sender = context.getSource().getSender();
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Error.SENDER_NOT_PLAYER.format());
            return 0;
        }

        final Block block = player.getTargetBlockExact(200);
        Location target;
        if (block != null) {
            target = block.getLocation();
        } else {
            Location location = player.getLocation();
            target = location.add(location.getDirection().multiply(5));
        }

        player.getWorld().strikeLightning(target);
        player.sendMessage(Info.CUSTOM.format("Location %1 has been smitten!", "TARGET_BLOCK"));
        return 1;
    }
}
