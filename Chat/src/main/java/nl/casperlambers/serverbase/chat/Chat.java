package nl.casperlambers.serverbase.chat;

import java.util.*;

public class Chat {
    private final Map<UUID, ChatChannel> playerChannelMap = new HashMap<>();

    public Map<UUID, ChatChannel> getPlayerChannelMap() {
        return playerChannelMap;
    }

    // Reverse lookup: Get all UUIDs using a given ChatChannel
    public List<UUID> getPlayersInChannel(ChatChannel channel) {
        List<UUID> result = new ArrayList<>();
        for (Map.Entry<UUID, ChatChannel> entry : playerChannelMap.entrySet()) {
            if (entry.getValue() == channel) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
