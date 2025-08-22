package nl.casperlambers.serverbase.core;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import nl.casperlambers.serverbase.core.command.Command_heal;
import nl.casperlambers.serverbase.core.command.Command_serverbase;
import nl.casperlambers.serverbase.core.command.Command_smite;

public class Bootstrap implements PluginBootstrap {
    @Override
    public void bootstrap(BootstrapContext bootstrapContext) {
        bootstrapContext.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register(
                    Command_smite.literalArgumentBuilder().build(),
                    "Smites players or the block on your crosshair"
            );
            commands.registrar().register(
                    Command_heal.literalArgumentBuilder().build(),
                    "Heals you or other players (for a value if specified)"
            );
            commands.registrar().register(
                    Command_serverbase.literalArgumentBuilder().build(),
                    "Default command"
            );
        });
    }
}
