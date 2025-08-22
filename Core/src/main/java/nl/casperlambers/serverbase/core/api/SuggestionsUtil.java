package nl.casperlambers.serverbase.core.api;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class SuggestionsUtil {

    private SuggestionsUtil() {

    }

    public static CompletableFuture<Suggestions> suggestOnlinePlayersWord(CommandContext<CommandSourceStack> context, SuggestionsBuilder builder) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            builder.suggest(player.getName());
        }
        return builder.buildFuture();
    }

    public static CompletableFuture<Suggestions> suggestOnlinePlayersGreedy(
            final CommandContext<CommandSourceStack> context,
            final SuggestionsBuilder builder
    ) {
        // Get only the part of the input after the argument start
        String typedSoFar = builder.getInput().substring(builder.getStart());

        // Split into already-typed words (names)
        String[] parts = typedSoFar.trim().split("\\s+");
        Set<String> usedNames = new HashSet<>(Arrays.asList(parts));

        // The last token is the one currently being completed
        String remaining = builder.getRemainingLowerCase();

        for (Player player : Bukkit.getOnlinePlayers()) {
            String name = player.getName();
            // Skip duplicates
            if (usedNames.contains(name)) continue;
            // Match partial input
            if (name.toLowerCase().startsWith(remaining)) {
                builder.suggest(name);
            }
        }

        return builder.buildFuture();
    }
}
