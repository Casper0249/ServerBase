package nl.casperlambers.serverbase.core.api;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;

public class ErrorMessages {
    /*

     */

    // Edit these to edit prefix
    private static final NamedTextColor errorPrefixColor = NamedTextColor.DARK_RED;
    private static final String errorPrefix = "[Error]:";

    // Edit these to edit message
    private static final String playerNotOnlineString = "Player % is not online";
    private static final String playerDoesntExistString = "Player % does not exist";
    private static final String sendNotPlayerString = "You are not a player";
    private static final String tooFewArgumentsString = "Too few arguments";


    public static String pasteIntoString(String message, String... strings) {
        if (message.chars().filter(c -> c == '%').count() != strings.length) {
            throw new IllegalArgumentException("Message string parser received incorrect amount of strings");
        }

        StringBuilder result = new StringBuilder();
        int stringIndex = 0;

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == '%') {
                // Replace % with the corresponding string
                result.append(strings[stringIndex]);
                stringIndex++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static TextComponent playerNotOnline(Player player) {
        return Component.text(errorPrefix, errorPrefixColor).append()
    }

    private Component component(String string) {
        return Component.text(string);
    }
}
