package nl.casperlambers.serverbase.core.api;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import nl.casperlambers.serverbase.core.CoreMain;
import nl.casperlambers.serverbase.core.command.Command_heal;
import nl.casperlambers.serverbase.core.command.Command_serverbase;
import nl.casperlambers.serverbase.core.command.Command_smite;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class ServerBaseAPI {
    private final CoreMain plugin;

    private final ArrayList<ServerBaseModule> loadedModules = new ArrayList<>();

    private static final String versionString = "1.0-SNAPSHOT";
    private final File savedDataFolder;

    public ServerBaseAPI(CoreMain plugin) {
        this.plugin = plugin;
        savedDataFolder = new File(plugin.getDataFolder(), "data");
    }

    /**
     * Checks if multiple files exist and creates them if they don't
     * @param names Names of the file to be created
     */
    public void requireFiles(String... names) {
        for (String name : names) {
            try {
                if (new File(plugin.getDataFolder(), name).createNewFile()) {
                    Bukkit.getLogger().log(Level.INFO, "File " + name + " not present, creating it now");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void newRequireFiles(ServerBaseFile... files) {
        for (ServerBaseFile serverBaseFile : files) {
            String name = serverBaseFile.getFileName();
            if (serverBaseFile.getDefaults() == null) {
                try {
                    if (new File(plugin.getDataFolder(), name).createNewFile()) {
                        Bukkit.getLogger().log(Level.INFO, "File " + name + " not present, creating empty file now...");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                plugin.saveResource(name, false);
                Bukkit.getLogger().log(Level.INFO, "File " + name + "not present, creating it now with defaults...");
            }
        }
    }

    /**
     * Gives you access to a file object in the ServerBase data folder.
     * @param name Name of file
     * @return Java file object with that name
     */
    public File getConfigFile(final String name) {
        return new File(plugin.getDataFolder(), name);
    }

    public File getDataFile(final String name) {
        return new File(savedDataFolder, name);
    }

    /**
     * Gives the current ServerBase version
     * @return Current version in string format
     */
    public static String getVersionString() {
        return versionString;
    }

    public File getSavedDataFolder() {
        return savedDataFolder;
    }

    public ArrayList<ServerBaseModule> getLoadedModules() {
        return loadedModules;
    }

    public void INJECT_MODULE(ServerBaseModule module) {
        Bukkit.getLogger().log(Level.INFO, "Loading ServerBase module '" + module.getModuleName() + "'");

        loadedModules.add(module);
        newRequireFiles(module.getConfigFiles());
        newRequireFiles(module.getDataFiles());

        for (LiteralCommandNode<CommandSourceStack> command : module.getCommands()) {
            plugin.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
                commands.registrar().register(command);
            });
        }
    }
}
