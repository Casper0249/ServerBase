package nl.casperlambers.serverbase.chat;

import nl.casperlambers.serverbase.chat.commands.Command_channel;
import nl.casperlambers.serverbase.chat.commands.Command_guild;
import nl.casperlambers.serverbase.chat.commands.Command_mail;
import nl.casperlambers.serverbase.chat.commands.Command_message;
import nl.casperlambers.serverbase.core.ServerBase;
import nl.casperlambers.serverbase.core.api.ServerBaseAPI;
import nl.casperlambers.serverbase.core.api.ServerBaseCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatMain extends JavaPlugin {
    public final ServerBaseAPI api = ServerBase.getAPI();
    private final ServerChat serverChat = new ServerChat();
    private final ServerBaseCommand[] commandList = {
            new Command_guild(),
            new Command_channel(),
            new Command_message(),
            new Command_mail()
    };
    private final String[] fileNameList = {
            "data/guilds.dat",
            "data/mail.dat"
    };

    @Override
    public void onEnable() {
        api.registerCommands(this, commandList);
        api.requireFiles(fileNameList);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ServerChat getChat() {
        return serverChat;
    }
}
