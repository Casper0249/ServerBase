package nl.casperlambers.serverbase.core.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import nl.casperlambers.serverbase.core.api.SuggestionsUtil;
import nl.casperlambers.serverbase.core.api.message.Error;
import nl.casperlambers.serverbase.core.api.message.Info;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_heal {

    private SuggestionsUtil suggestionsUtil = new SuggestionsUtil();

    public static LiteralArgumentBuilder<CommandSourceStack> literalArgumentBuilder() {
        return Commands.literal("heal")
                .requires(commandSourceStack -> commandSourceStack.getSender().hasPermission("serverbase.core.heal"))
                .executes(Command_heal::healFull)
                .then(Commands.argument("values", StringArgumentType.greedyString())
                        .suggests(SuggestionsUtil::suggestOnlinePlayersGreedy)
                        .executes(Command_heal::healMain)
                );
    }

    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    private static int healFull(CommandContext<CommandSourceStack> context) {
        CommandSender sender = context.getSource().getSender();
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Error.SENDER_NOT_PLAYER.format());
            return 0;
        }

        player.setHealth(player.getAttribute(Attribute.MAX_HEALTH).getValue());
        sender.sendMessage(Info.CUSTOM.format("You have been healed to full health"));
        return 1;
    }

    private static int healMain(CommandContext<CommandSourceStack> context) {
        int healedPlayers = 0;
        final CommandSender sender = context.getSource().getSender();
        String[] args = context.getArgument("values", String.class).trim().split("\\s+");
        if (isDouble(args[0])) {
            double healTo = Double.parseDouble(args[0]);
            if (args.length < 2) {
                if (!(sender instanceof Player player)) {
                    sender.sendMessage(Error.SENDER_NOT_PLAYER.format());
                    return 0;
                }
                double maxHealth = player.getAttribute(Attribute.MAX_HEALTH).getValue();
                if (healTo > maxHealth) {
                    healTo = maxHealth;
                }
                player.setHealth(healTo);
                sender.sendMessage(Info.CUSTOM.format("You have been healed to %1 health", args[0]));
                healedPlayers++;
            } else {
                for (int i = 1; i < args.length; i++) {
                    final Player player = Bukkit.getPlayer(args[i]);
                    if (player == null) {
                        sender.sendMessage(Error.PLAYER_OFFLINE.format(args[i]));
                        continue;
                    }
                    double maxHealth = player.getAttribute(Attribute.MAX_HEALTH).getValue();
                    if (healTo > maxHealth) {
                        healTo = maxHealth;
                    }
                    player.setHealth(healTo);
                    healedPlayers++;
                    sender.sendMessage(Info.CUSTOM.format("Player %1 has been healed to %2 health", args[i], args[0]));
                }
            }
        } else {
            for (String arg : args) {
                final Player player = Bukkit.getPlayer(arg);
                if (player == null) {
                    sender.sendMessage(Error.PLAYER_OFFLINE.format(arg));
                    continue;
                }
                player.setHealth(player.getAttribute(Attribute.MAX_HEALTH).getValue());
                healedPlayers++;
                sender.sendMessage(Info.CUSTOM.format("Player %1 has been healed to full health", arg));
            }
        }
        return healedPlayers;
    }
}
