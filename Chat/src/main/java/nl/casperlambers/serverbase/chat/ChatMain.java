package nl.casperlambers.serverbase.chat;

import nl.casperlambers.serverbase.chat.commands.Command_channel;
import nl.casperlambers.serverbase.chat.commands.Command_guild;
import nl.casperlambers.serverbase.core.ServerBase;
import nl.casperlambers.serverbase.core.api.ServerBaseCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatMain extends JavaPlugin {
    private final ServerChat serverChat = new ServerChat();
    private final ServerBaseCommand[] commandList = {
            new Command_guild(),
            new Command_channel()
    };
    private final String[] fileNameList = {
            "data/guilds.dat"
    };

    @Override
    public void onEnable() {
        ServerBase.getAPI().registerCommands(this, commandList);
        ServerBase.getAPI().requireFiles(fileNameList);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ServerChat getChat() {
        return serverChat;
    }
}
