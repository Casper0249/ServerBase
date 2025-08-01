package nl.casperlambers.serverbase.core.commands;

import nl.casperlambers.serverbase.core.ServerBase;
import nl.casperlambers.serverbase.core.api.ErrorMessages;
import nl.casperlambers.serverbase.core.api.ServerBaseAPI;
import nl.casperlambers.serverbase.core.api.ServerBaseCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_smite implements ServerBaseCommand {
    private final ServerBaseAPI api = ServerBase.getAPI();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("smite")) {
            if (args.length > 0) {
                for (String arg : args) {
                    if (Bukkit.getPlayer(arg) != null) {
                        Player player = Bukkit.getPlayer(arg);
                        assert player != null;
                        player.getWorld().strikeLightning(player.getLocation());
                        sender.sendMessage("Player " + api.colorSecondary + arg + api.colorMain + " has been smitten!");
                        continue;
                    }
                    sender.sendMessage("Player " + api.colorSecondary + arg + api.colorMain + " is not online");
                }
            } else {
                if (sender instanceof Player player) {
                    Location loc = player.getCompassTarget();
                    player.getWorld().strikeLightning(loc);
                    sender.sendMessage("Block " + api.colorSecondary + loc.getX() + " " + loc.getY() + " " + loc.getZ() + api.colorMain + " has been smitten!");
                } else {
                    sender.sendMessage(api.colorErrorMain + "You are not a player");
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String getCommandName() {
        return "smite";
    }
}
