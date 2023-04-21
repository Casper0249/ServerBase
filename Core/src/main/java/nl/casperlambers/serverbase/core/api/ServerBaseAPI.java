package nl.casperlambers.serverbase.core.api;

import nl.casperlambers.serverbase.core.ServerBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class ServerBaseAPI {
    private final ServerBase plugin = ServerBase.getPlugin(ServerBase.class);

    public final String versionString = "1.0-SNAPSHOT";

    public ChatColor colorMain = ChatColor.RESET;
    public ChatColor colorSecondary = ChatColor.AQUA;
    public ChatColor colorErrorMain = ChatColor.RED;
    public ChatColor colorErrorSecondary = ChatColor.DARK_RED;

    /**
     * Checks if a file exists and creates it if it doesn't.
     * @param name Name of the file to be created
     */
    public void requireFile(final String name) {
        try {
            if (new File(plugin.getDataFolder(), name).createNewFile()) {
                Bukkit.getLogger().log(Level.INFO, "File " + name + " not present, creating it now");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    /**
     * Gives you access to a YamlConfiguration object of a file object in the ServerBase data folder.
     * Might cause errors if the file does not exist.
     * @param name Name of file
     * @return Loaded YamlConfiguration of a file with specified name
     */
    public YamlConfiguration toConfig(final String name) {
        return YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), name));
    }
}
