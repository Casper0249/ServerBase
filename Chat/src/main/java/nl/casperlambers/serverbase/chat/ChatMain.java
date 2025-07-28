package nl.casperlambers.serverbase.chat;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChatMain extends JavaPlugin {
    private final Chat chat = new Chat();

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Chat getChat() {
        return chat;
    }
}
