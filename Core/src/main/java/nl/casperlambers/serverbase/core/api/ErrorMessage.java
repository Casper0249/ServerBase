package nl.casperlambers.serverbase.core.api;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;

public enum ErrorMessage {
    PLAYER_OFFLINE("Player % is not online"),
    TOO_FEW_ARGUMENTS("Too few arguments");

    private final String prefixString = "[Error]";
    private final NamedTextColor prefixColor = NamedTextColor.DARK_RED;
    private final Component prefix = Component.text(prefixString, prefixColor);

    ErrorMessage(String s) {
    }

    public TextComponent formatSuper(String... strings) {

    }

    public TextComponent format(String... string) {
        return null;
    }
}

