package nl.casperlambers.serverbase.core.api.message;

import net.kyori.adventure.text.Component;
import nl.casperlambers.serverbase.core.api.ServerBaseColor;

import java.util.Arrays;

public enum Error implements Formattable {
    CUSTOM("") {
        @Override
        public Component format(String... args) {
            return Message.formatTemplate(ERROR_PREFIX, ServerBaseColor.ERROR_MAIN, ServerBaseColor.ERROR_ALT, args[0], Arrays.copyOfRange(args, 1, args.length));
        }
    },
    TOO_FEW_ARGUMENTS("Too few arguments"),
    TOO_MANY_ARGUMENTS("Too many arguments"),
    INVALID_ARGUMENT("'%1' is an invalid argument"),
    INVALID_ARGUMENTS("Invalid argument(s)"),
    PLAYER_NONEXISTENT("Player %1 could not be found."),
    PLAYER_OFFLINE("Player %1 is not online."),
    SENDER_NOT_PLAYER("You are not a player");

    private final String template;
    private static final Component ERROR_PREFIX = Component.text("Error: ", ServerBaseColor.ERROR_ALT);

    Error(String template) {
        this.template = template;
    }

    @Override
    public Component format(String... args) {
        return Message.formatTemplate(ERROR_PREFIX, ServerBaseColor.ERROR_MAIN, ServerBaseColor.ERROR_ALT, template, args);
    }
}
