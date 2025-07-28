package nl.casperlambers.serverbase.chat;

public enum ChatChannel {
    GENERAL("General"),
    LOCAL("Local");

    private final String channelName;

    ChatChannel(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }
}
