package nl.casperlambers.serverbase.core.api.message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Message {
    // Shared formatting method
    public static Component formatTemplate(Component prefix, NamedTextColor mainColor, NamedTextColor altColor, String template, String... args) {
        // Match both %1, %2... and &%1, &%2...
        Pattern pattern = Pattern.compile("(&)?%(\\d+)");
        Matcher matcher = pattern.matcher(template);

        Component result = prefix;
        int lastIndex = 0;

        while (matcher.find()) {
            // Add static text before the match
            String before = template.substring(lastIndex, matcher.start());
            result = result.append(Component.text(before, mainColor));

            // Check for optional '&' and get argument index
            boolean isMain = matcher.group(1) != null;
            int argIndex = Integer.parseInt(matcher.group(2)) - 1;

            NamedTextColor color = isMain ? mainColor : altColor;

            if (argIndex >= 0 && argIndex < args.length) {
                result = result.append(Component.text(args[argIndex], color));
            } else {
                result = result.append(Component.text(matcher.group(), NamedTextColor.GRAY));
            }

            lastIndex = matcher.end();
        }

        // Add remaining static text
        if (lastIndex < template.length()) {
            result = result.append(Component.text(template.substring(lastIndex), mainColor));
        }

        return result;
    }
}
