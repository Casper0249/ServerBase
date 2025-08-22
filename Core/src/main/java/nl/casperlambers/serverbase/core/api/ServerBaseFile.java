package nl.casperlambers.serverbase.core.api;

import javax.annotation.Nullable;
import java.io.File;
import java.io.InputStream;

public class ServerBaseFile {
    private final String fileName;
    private InputStream defaults = null;

    public ServerBaseFile(String fileName) {
        this.fileName = fileName;
    }

    public ServerBaseFile(String fileName, @Nullable InputStream defaults) {
        this.fileName = fileName;
        this.defaults = defaults;
    }

    public String getFileName() {
        return fileName;
    }

    public InputStream getDefaults() {
        return defaults;
    }
}
