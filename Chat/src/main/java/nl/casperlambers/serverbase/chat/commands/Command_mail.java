package nl.casperlambers.serverbase.chat.commands;

import nl.casperlambers.serverbase.chat.ChatMain;
import nl.casperlambers.serverbase.chat.ServerChat;
import nl.casperlambers.serverbase.core.api.ServerBaseCommand;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Command_mail implements ServerBaseCommand {
    ServerChat serverChat = ChatMain.getPlugin(ChatMain.class).getChat();

    @Override
    public String getCommandName() {
        return "mail";
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (command.getLabel().equalsIgnoreCase(getCommandName())) {
            if (strings.length < 1) {
                commandSender.sendMessage(ChatColor.RED + "Error: Please include a message");
                return false;
            }
            Server server = commandSender.getServer();
            if (server.getPlayer(strings[0]) == null || server.getOfflinePlayer(strings[0]) == null) {
                commandSender.sendMessage(ChatColor.RED + "Error: that player does not exist or has never joined the server");
                return true;
            }

            String fullMailString = "06-08-2007:Casper0249:Hey kanker mongool";

            serverChat.getSocialPlayerHashMap().get()

            return true;
        }
        return false;
    }
}
