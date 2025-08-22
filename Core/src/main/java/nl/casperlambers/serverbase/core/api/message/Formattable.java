package nl.casperlambers.serverbase.core.api.message;

import net.kyori.adventure.text.Component;

public interface Formattable {
    Component format(String... args);
}
