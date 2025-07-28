package nl.casperlambers.serverbase.chat.commands;

import nl.casperlambers.serverbase.core.api.ServerBaseCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Command_channel implements ServerBaseCommand {
    @Override
    public String getCommandName() {
        return "channel";
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (command.getLabel().equalsIgnoreCase(getCommandName())) {
            switch (args[0]) {
                case "mute":
                    switch ()
            }
        }
        return false;
    }
}
