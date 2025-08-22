package nl.casperlambers.serverbase.social;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import nl.casperlambers.serverbase.core.CoreMain;
import nl.casperlambers.serverbase.core.api.ServerBaseAPI;
import nl.casperlambers.serverbase.core.api.ServerBaseFile;
import nl.casperlambers.serverbase.core.api.ServerBaseModule;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SocialMain extends JavaPlugin implements ServerBaseModule {
    public final ServerBaseAPI api = Objects.requireNonNull(getServer().getServicesManager().getRegistration(ServerBaseAPI.class)).getProvider();

    @Override
    public void onEnable() {
        api.INJECT_MODULE(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public String getModuleName() {
        return "";
    }

    @Override
    public ServerBaseFile[] getConfigFiles() {
        return new ServerBaseFile[]{
        };
    }

    @Override
    public ServerBaseFile[] getDataFiles() {
        return new ServerBaseFile[]{
                new ServerBaseFile("guild.dat")
        };
    }

    @Override
    public LiteralCommandNode<CommandSourceStack>[] getCommands() {
        return new LiteralCommandNode[0];
    }
}
