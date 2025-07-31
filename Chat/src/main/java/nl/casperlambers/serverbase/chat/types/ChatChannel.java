package nl.casperlambers.serverbase.chat.types;

public enum ChatChannel {
    GENERAL("General"),
    LOCAL("Local"),
    GUILD("Guild");

    private final String channelName;
    private static final int localDistanceMax = 200;

    ChatChannel(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public static int getLocalDistanceMax() {
        return localDistanceMax;
    }
}
