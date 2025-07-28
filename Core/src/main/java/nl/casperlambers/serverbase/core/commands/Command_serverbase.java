package nl.casperlambers.serverbase.core.commands;

import nl.casperlambers.serverbase.core.ServerBase;
import nl.casperlambers.serverbase.core.api.ServerBaseAPI;
import nl.casperlambers.serverbase.core.api.ServerBaseCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Command_serverbase implements ServerBaseCommand {
    private final ServerBaseAPI api = ServerBase.getAPI();

    @Override
    public String getCommandName() {
        return "serverbase";
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getLabel().equalsIgnoreCase(getCommandName())) {
            commandSender.sendMessage(api.colorMain + "ServerBase version " + api.colorSecondary + api.versionString);
            return true;
        }
        return false;
    }
}
