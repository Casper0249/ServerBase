package nl.casperlambers.serverbase.core.commands;

import nl.casperlambers.serverbase.core.ServerBase;
import nl.casperlambers.serverbase.core.api.ServerBaseAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_serverbase implements CommandExecutor {
    private final ServerBase plugin = ServerBase.getPlugin(ServerBase.class);
    private final ServerBaseAPI api = plugin.getAPI();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getLabel().equalsIgnoreCase("serverbase")) {
            commandSender.sendMessage(api.colorSecondary + "ServerBase" + api.colorMain + "version " + api.versionString);
            return true;
        }
        return false;
    }
}
