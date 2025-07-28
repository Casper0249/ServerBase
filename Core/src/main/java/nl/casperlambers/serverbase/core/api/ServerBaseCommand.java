package nl.casperlambers.serverbase.core.api;

import org.bukkit.command.CommandExecutor;

public interface ServerBaseCommand extends CommandExecutor {
    String getCommandName();
}
