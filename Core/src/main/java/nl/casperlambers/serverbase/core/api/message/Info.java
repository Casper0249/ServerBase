package nl.casperlambers.serverbase.core.api.message;

import net.kyori.adventure.text.Component;
import nl.casperlambers.serverbase.core.api.ServerBaseColor;

import java.util.Arrays;

public enum Info implements Formattable {
    CUSTOM("") {
        @Override
        public Component format(String... args) {
            return Message.formatTemplate(INFO_PREFIX, ServerBaseColor.INFO_MAIN, ServerBaseColor.INFO_ALT, args[0], Arrays.copyOfRange(args, 1, args.length));
        }
    },
    COMMAND_SUCCESS("The command %1 executed successfully."),
    PLAYER_TELEPORTED("Teleported %1 to %2."),
    OBJECT_INTERACT("&%1 %2 has been &%3"),
    RELOADED("Reload complete.");

    private final String template;
    private static final Component INFO_PREFIX = Component.text("Info: ", ServerBaseColor.INFO_ALT);

    Info(String template) {
        this.template = template;
    }

    @Override
    public Component format(String... args) {
        return Message.formatTemplate(INFO_PREFIX, ServerBaseColor.INFO_MAIN, ServerBaseColor.INFO_ALT, template, args);
    }
}
