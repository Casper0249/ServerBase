package nl.casperlambers.serverbase.core;

import nl.casperlambers.serverbase.core.api.ServerBaseAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

public final class ServerBase extends JavaPlugin {
    private final ServerBaseAPI api = new ServerBaseAPI();

    /**
     * Use to gain access to the ServerBase API
     * @return A new instance of the ServerBaseAPI class
     */
    public ServerBaseAPI getAPI() {
        return new ServerBaseAPI();
    }
    @Override
    public void onEnable() {
        if(!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
