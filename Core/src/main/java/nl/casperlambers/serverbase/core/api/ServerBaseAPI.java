package nl.casperlambers.serverbase.core.api;

import nl.casperlambers.serverbase.core.ServerBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.beans.JavaBean;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;

public class ServerBaseAPI {
    private final ServerBase plugin = ServerBase.getPlugin(ServerBase.class);

    private final String versionString = "1.0-SNAPSHOT";

    public ChatColor colorMain = ChatColor.RESET;
    public ChatColor colorSecondary = ChatColor.AQUA;
    public ChatColor colorErrorMain = ChatColor.RED;
    public ChatColor colorErrorSecondary = ChatColor.DARK_RED;

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

    /**
     * Gives you access to a file object in the ServerBase data folder.
     * @param name Name of file
     * @return Java file object with that name
     */
    public File getFile(final String name) {
        return new File(plugin.getDataFolder(), name);
    }

    public void registerCommands(JavaPlugin javaPlugin, ServerBaseCommand... commands) {
        for (ServerBaseCommand serverBaseCommand : commands) {
            Objects.requireNonNull(javaPlugin.getCommand(serverBaseCommand.getCommandName())).setExecutor(serverBaseCommand);
        }
    }

    public String getVersionString() {
        return versionString;
    }
}
