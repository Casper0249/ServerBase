package nl.casperlambers.serverbase.chat.types;

public enum GuildRank {
    LEADER(0),
    COLEADER(1),
    ELDER(2),
    DEFAULT(3);

    private final int level;

    GuildRank(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
