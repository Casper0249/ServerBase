package nl.casperlambers.serverbase.chat.commands;

import nl.casperlambers.serverbase.core.api.ServerBaseCommand;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Command_guild implements ServerBaseCommand {
    @Override
    public String getCommandName() {
        return "guild";
    }

    private void create(String[] args) {

    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (command.getLabel().equalsIgnoreCase(getCommandName())) {
            switch (args[0]) {
                case "create":
                    create(args);
                    break;
                default:
                    commandSender.sendMessage(Color.RED + "Error: invalid argument");
                    return false;
            }
            return true;
        }
        return false;
    }
}
