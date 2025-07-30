package nl.casperlambers.serverbase.core;

import nl.casperlambers.serverbase.core.api.ServerBaseAPI;
import nl.casperlambers.serverbase.core.api.ServerBaseCommand;
import nl.casperlambers.serverbase.core.commands.Command_serverbase;
import nl.casperlambers.serverbase.core.commands.Command_smite;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public final class ServerBase extends JavaPlugin {
    private static final ServerBaseAPI api = new ServerBaseAPI();
    private final File secondDataFolder = new File(getDataFolder(), "data");

    private final ServerBaseCommand[] commandList = { // Add command to this list to register it
            new Command_serverbase(),
            new Command_smite()
    };

    private final String[] fileNameList = { // Add filename to this list to create it
            "config.yml",
            "colors.yml",
            "data/player_preferences.dat"
    };

    /**
     * Use to gain access to the ServerBase API
     * @return A new instance of the ServerBaseAPI class
     */
    public static ServerBaseAPI getAPI() {
        return api;
    }

    @Override
    public void onEnable() {
        if (getDataFolder().mkdir()) { // Creates plugin folder if it doesn't exist yet
            getLogger().log(Level.INFO, "SeverBase plugin folder not present, creating it now...");
        }
        if (secondDataFolder.mkdir()) { // Creates data folder if it doesn't exist yet
            getLogger().log(Level.INFO, "ServerBase data folder not present, creating it now...");
        }

        api.init(this);
        api.registerCommands(this, commandList);
        api.requireFiles(fileNameList);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
