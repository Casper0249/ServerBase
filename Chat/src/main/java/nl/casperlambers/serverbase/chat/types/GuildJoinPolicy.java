package nl.casperlambers.serverbase.chat.types;

public enum GuildJoinPolicy {
    OPEN(0),
    SEMI_OPEN(1),
    INVITE_ONLY(2);

    GuildJoinPolicy(int level) {
    }
}
