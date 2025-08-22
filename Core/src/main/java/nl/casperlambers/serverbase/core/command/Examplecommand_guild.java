package nl.casperlambers.serverbase.core.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import nl.casperlambers.serverbase.core.api.message.Error;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static io.papermc.paper.command.brigadier.Commands.argument;
import static io.papermc.paper.command.brigadier.Commands.literal;

public class Examplecommand_guild {

    public static LiteralCommandNode<CommandSourceStack> commandNode() {
        return literal("guild")
                .requires(commandSourceStack -> commandSourceStack.getSender().hasPermission("serverbase.social.guild"))
                .then(literal("admin")
                        .then(literal("set")
                                .then(literal("tag")
                                        .then(argument("tag", StringArgumentType.word())
                                                .executes(Examplecommand_guild::setTag)
                                        )
                                )
                                .then(literal("fulldisplayname")
                                        .then(Commands.argument("newDisplayName", StringArgumentType.greedyString())
                                                .executes(Examplecommand_guild::setFullDisplayName)
                                        )
                                )
                                .then(literal("joinpolicy")
                                        .then(Commands.argument("joinPolicy", StringArgumentType.word())
                                                .executes(Examplecommand_guild::setJoinPolicy)
                                        )
                                )
                        )
                        .then(literal("deleteguild")
                                .requires(Commands.restricted(commandSourceStack -> true))
                                .executes(Examplecommand_guild::deleteguild)
                        )
                        .then(literal("kick")
                                .then(Commands.argument("playerName", StringArgumentType.word())
                                        .executes(Examplecommand_guild::kick)
                                )
                        )
                        .then(literal("promote")
                                .then(Commands.argument("playerName", StringArgumentType.word())
                                        .executes(Examplecommand_guild::promote)
                                )
                        )
                        .then(literal("demote"))
                )
                .then(literal("list")
                        .executes(Examplecommand_guild::list)
                )
                .then(literal("info")
                        .then(argument("guildName", StringArgumentType.word())
                                .executes(Examplecommand_guild::info)
                        )
                )
                .then(literal("create")
                        .then(Commands.argument("guildName", StringArgumentType.word())
                                .executes(Examplecommand_guild::create)
                        )
                )
                .then(literal("join")
                        .then(Commands.argument("guildName", StringArgumentType.word())
                                .executes(Examplecommand_guild::join)
                        )
                )
                .then(literal("invite")
                        .then(Commands.argument("playerName", StringArgumentType.word())
                                .executes(Examplecommand_guild::invite)
                        )
                )
                .then(literal("leave")
                        .executes(Examplecommand_guild::leave)
                )
                .build();
    }

    private static int info(CommandContext<CommandSourceStack> context) {
    }

    private static int list(CommandContext<CommandSourceStack> context) {
    }

    private static int leave(CommandContext<CommandSourceStack> context) {
    }

    private static int invite(CommandContext<CommandSourceStack> context) {
    }

    private static int join(CommandContext<CommandSourceStack> context) {
    }

    private static int promote(CommandContext<CommandSourceStack> context) {
        Player player = Bukkit.getPlayer(context.getArgument("playerName", String.class));
        if (player == null) {
            context.getSource().getSender().sendMessage();
        }
    }

    private static int kick(CommandContext<CommandSourceStack> context) {
    }

    private static int deleteguild(CommandContext<CommandSourceStack> context) {
    }

    private static int setJoinPolicy(CommandContext<CommandSourceStack> context) {
    }

    private static int setFullDisplayName(CommandContext<CommandSourceStack> context) {
    }

    private static int setTag(CommandContext<CommandSourceStack> context) {
    }

    private static int create(CommandContext<CommandSourceStack> context) {
        CommandSender sender = context.getSource().getSender();
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Error.SENDER_NOT_PLAYER.format());
            sender.sendMessage(Error.CUSTOM.format("Only players can own guilds"));
            return 0;
        }
    }
}
