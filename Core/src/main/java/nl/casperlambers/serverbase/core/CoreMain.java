package nl.casperlambers.serverbase.core;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import nl.casperlambers.serverbase.core.api.*;
import nl.casperlambers.serverbase.core.command.Command_heal;
import nl.casperlambers.serverbase.core.command.Examplecommand_guild;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public final class CoreMain extends JavaPlugin implements ServerBaseModule {
    private static ServerBaseAPI api;

    private final ServerBaseFile[] fileList = {
            new ServerBaseFile("config.yml", getResource("config.yml")),
            new ServerBaseFile("colors.yml", getResource("colors.yml"))
    };

    public static ServerBaseAPI getAPI() {
        return api;
    }

    @Override
    public void onEnable() {
        api = new ServerBaseAPI(this);
        getServer().getServicesManager().register(ServerBaseAPI.class, api, this, ServicePriority.Normal);

        api.INJECT_MODULE(this);

        if (!getDataFolder().exists()) {
            Bukkit.getLogger().log(Level.INFO, "Plugin folder not present, creating it now...");
            getDataFolder().mkdir();
        }
        if (!api.getSavedDataFolder().exists()) {
            Bukkit.getLogger().log(Level.INFO, "Saved data folder not present, creating it now...");
            api.getSavedDataFolder().mkdir();
        }

        ServerBaseColor.loadColors();
    }

    @EventHandler
    private void pluginLoad(PluginEnableEvent event) {
        if (event.getPlugin() instanceof ServerBaseModule module) {
            module.getCommands()
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public String getModuleName() {
        return "Core";
    }

    @Override
    public ServerBaseFile[] getConfigFiles() {
        return new ServerBaseFile[0];
    }

    @Override
    public ServerBaseFile[] getDataFiles() {
        return new ServerBaseFile[0];
    }

    @Override
    public List<LiteralCommandNode<CommandSourceStack>> getCommandNodes() {
        return List.of(
                Examplecommand_guild.commandNode()
        );
    }

    @Override
    public List<ServerBaseFile> getFiles() {
        return List.of(
                new ServerBaseFile()
        );
    }
}
