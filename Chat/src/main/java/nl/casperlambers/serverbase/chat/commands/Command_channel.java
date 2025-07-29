package nl.casperlambers.serverbase.chat.commands;

import nl.casperlambers.serverbase.chat.ChatChannel;
import nl.casperlambers.serverbase.chat.ChatMain;
import nl.casperlambers.serverbase.chat.ServerChat;
import nl.casperlambers.serverbase.core.api.ServerBaseCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.nio.channels.Channel;

public class Command_channel implements ServerBaseCommand {
    private final ServerChat serverChat = ChatMain.getPlugin(ChatMain.class).getChat();

    @Override
    public String getCommandName() {
        return "channel";
    }

    private void mute(String[] args, CommandSender sender) {
        switch (args[1]) {
            case "general":
                serverChat.getChannelMuteMap().get(ChatChannel.GENERAL).add((Player) sender);
                break;
            default:
                sender.sendMessage(ChatColor.RED + "Error: that is not a valid channel");
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (command.getLabel().equalsIgnoreCase(getCommandName())) {
            switch (args[0]) {
                case "mute":
                    mute(args, commandSender);
                case "unmute":

            }
        }
        return false;
    }
}
