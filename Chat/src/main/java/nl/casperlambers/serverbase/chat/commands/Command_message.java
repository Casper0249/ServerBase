package nl.casperlambers.serverbase.chat.commands;

import nl.casperlambers.serverbase.core.api.ServerBaseCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Command_message implements ServerBaseCommand {
    @Override
    public String getCommandName() {
        return "message";
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if(command.getLabel().equalsIgnoreCase(getCommandName())) {
            if (commandSender.getServer().getPlayer(strings[0]) == null) {
                commandSender.sendMessage(ChatColor.RED + "Player " + strings[0] + " is not online");
                return true;
            }
            if (strings.length > 1) {
                final Player recipient = commandSender.getServer().getPlayer(strings[0]);
                final String message =  String.join(" ", Arrays.copyOfRange(strings, 1, strings.length));
                assert recipient != null;
                recipient.sendMessage(message);
            }
        }
        return false;
    }
}
