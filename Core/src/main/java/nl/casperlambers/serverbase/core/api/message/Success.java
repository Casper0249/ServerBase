package nl.casperlambers.serverbase.core.api.message;

import net.kyori.adventure.text.Component;
import nl.casperlambers.serverbase.core.api.ServerBaseColor;

import java.util.Arrays;

public enum Success implements Formattable {
    CREATED("Successfully created %1."),
    SAVED("Changes to %1 have been saved."),
    JOINED("You have joined %1."),
    CUSTOM("") {
        @Override
        public Component format(String... args) {
            return Message.formatTemplate(SUCCESS_PREFIX, ServerBaseColor.SUCCESS_MAIN, ServerBaseColor.SUCCESS_ALT, args[0], Arrays.copyOfRange(args, 1, args.length));
        }
    },;

    private final String template;
    private static final Component SUCCESS_PREFIX = Component.text("Success: ", ServerBaseColor.SUCCESS_ALT);

    Success(String template) {
        this.template = template;
    }

    @Override
    public Component format(String... args) {
        return Message.formatTemplate(SUCCESS_PREFIX, ServerBaseColor.SUCCESS_MAIN, ServerBaseColor.SUCCESS_ALT, template, args);
    }
}
