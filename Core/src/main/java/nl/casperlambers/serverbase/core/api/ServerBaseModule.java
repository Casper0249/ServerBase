package nl.casperlambers.serverbase.core.api;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;

import java.util.ArrayList;
import java.util.List;

public interface ServerBaseModule {
    String getModuleName();
    ServerBaseFile[] getConfigFiles();
    ServerBaseFile[] getDataFiles();
    List<LiteralCommandNode<CommandSourceStack>> getCommandNodes();
    List<ServerBaseFile> getFiles();
}
