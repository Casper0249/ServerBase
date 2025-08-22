package nl.casperlambers.serverbase.core.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import net.kyori.adventure.text.Component;
import nl.casperlambers.serverbase.core.CoreMain;
import nl.casperlambers.serverbase.core.api.*;
import nl.casperlambers.serverbase.core.api.message.Info;
import org.bukkit.command.CommandSender;

public class Command_serverbase {
    private static final ServerBaseAPI api = CoreMain.getPlugin(CoreMain.class).getAPI();

    public static LiteralArgumentBuilder<CommandSourceStack> literalArgumentBuilder() {
        return Commands.literal("serverbase")
                .requires(commandSourceStack -> commandSourceStack.getSender().hasPermission("serverbase.core.maincommand"))
                .executes(Command_serverbase::message);
    }

    private static int message(CommandContext<CommandSourceStack> ctx) {
        CommandSender sender = ctx.getSource().getSender();
        sender.sendMessage(Info.CUSTOM.format("ServerBase version", ServerBaseAPI.getVersionString()));
        sender.sendMessage(Component.text("Loaded modules:"));
        for (ServerBaseModule module : api.getLoadedModules()) {
            sender.sendMessage(Component.text(" - ").append(Component.text(module.getModuleName(), ServerBaseColor.INFO_ALT)));
        }
        return 1;
    }
}
