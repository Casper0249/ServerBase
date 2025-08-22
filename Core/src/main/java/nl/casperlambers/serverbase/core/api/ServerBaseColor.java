package nl.casperlambers.serverbase.core.api;

import net.kyori.adventure.text.format.NamedTextColor;
import nl.casperlambers.serverbase.core.CoreMain;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.logging.Level;

public class ServerBaseColor {
    private static final YamlConfiguration colorsConfig = YamlConfiguration.loadConfiguration(CoreMain.getAPI().getConfigFile("colors.yml"));

    public static NamedTextColor INFO_MAIN;
    public static NamedTextColor INFO_ALT;
    public static NamedTextColor ERROR_MAIN;
    public static NamedTextColor ERROR_ALT;
    public static NamedTextColor SUCCESS_MAIN;
    public static NamedTextColor SUCCESS_ALT;

    public static void loadColors() {
        INFO_MAIN = parseColor("info-main");
        INFO_ALT = parseColor("info-alt");
        ERROR_MAIN = parseColor("error-main");
        ERROR_ALT = parseColor("error-alt");
        SUCCESS_MAIN = parseColor("success-main");
        SUCCESS_ALT = parseColor("success-alt");
    }

    private static NamedTextColor parseColor(String key) {
        String value = colorsConfig.getString(key);
        if (value == null) {
            Bukkit.getLogger().log(Level.WARNING, "Missing color for key: " + key);
            Bukkit.getLogger().log(Level.WARNING, "Setting color to default WHITE");
            return NamedTextColor.WHITE;
        }

        NamedTextColor color = NamedTextColor.NAMES.value(value.toLowerCase());
        if (color == null) {
            Bukkit.getLogger().log(Level.WARNING, "Invalid color name in config: " + value + " (key: " + key + ")");
            return NamedTextColor.WHITE;
        }

        return color;
    }
}
