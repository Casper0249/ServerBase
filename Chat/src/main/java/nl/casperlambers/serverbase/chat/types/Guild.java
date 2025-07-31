package nl.casperlambers.serverbase.chat.types;

import nl.casperlambers.serverbase.core.ServerBase;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Guild {
    private static final YamlConfiguration guildsDataFileConfig = YamlConfiguration.loadConfiguration(ServerBase.getAPI().getFile("data/guilds.dat"));

    private String name;
    private String displayName;
    private String tag;
    private UUID leaderUUID;
    private GuildJoinPolicy joinPolicy;
    private HashMap<GuildRank, ArrayList<Player>> members;

    public Guild(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getTag() {
        return tag;
    }

    public UUID getLeader() {
        return leaderUUID;
    }

    public GuildJoinPolicy getJoinPolicy() {
        return joinPolicy;
    }

    public HashMap<GuildRank, ArrayList<Player>> getMembersByRank() {
        return members;
    }

    public ArrayList<Player> getMembersAll() {
        ArrayList<Player> arrayList = new ArrayList<>();

        arrayList.addAll(members.get(GuildRank.LEADER));
        arrayList.addAll(members.get(GuildRank.COLEADER));
        arrayList.addAll(members.get(GuildRank.ELDER));
        arrayList.addAll(members.get(GuildRank.DEFAULT));

        return arrayList;
    }

    public static boolean guildExists(String guildName) {
        return guildsDataFileConfig.contains(guildName);
    }

    public static boolean playerHasGuild(Player player) {
        return guildsDataFileConfig.contains(player.getUniqueId().toString());
    }

    public static void createGuild(String guildName, UUID ownerUUID) {
        guildsDataFileConfig.set(guildName + ".owner", ownerUUID);
    }

    public static void setGuildDisplayName(String guildName, String guildDisplayName) {
        guildsDataFileConfig.set(guildName + ".display-name", guildDisplayName);
    }

    public static void setGuildTag(String guildName, String guildTag) {
        guildsDataFileConfig.set(guildName + ".guild-tag", guildTag);
    }

    public static void setGuildJoinPolicy(String guildName, int joinPolicy) {
        guildsDataFileConfig.set(guildName + ".join-policy", joinPolicy);
    }
}
