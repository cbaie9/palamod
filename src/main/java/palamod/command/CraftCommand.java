package palamod.command;

import palamod.procedures.OpenCraftingTableProcedure;
import palamod.procedures.MsgtellrawautosendProcedure;
import palamod.init.PalamodModGameRules;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.players.NameAndId;

@EventBusSubscriber
public class CraftCommand {

    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {

        event.getDispatcher().register(
            Commands.literal("craft")
                .executes(context -> {

                    CommandSourceStack source = context.getSource();
                    ServerPlayer player;

                    try {
                        player = source.getPlayerOrException();
                    } catch (Exception e) {
                        return 0; // Empêche la console d'utiliser la commande
                    }
					 NameAndId nameAndId = new NameAndId(player.getUUID(), player.getName().getString());
                    boolean gameruleAccess = player.level()
                            .getGameRules()
                            .get(PalamodModGameRules.COMMAND_CRAFT_NO_PERM_ACCESS.get());

                    boolean isOp = source.getServer()
   					 						.getPlayerList()
    										.isOp(nameAndId);

                    if (gameruleAccess || isOp) {

                        OpenCraftingTableProcedure.execute(
                                player.level(),
                                player.getX(),
                                player.getY(),
                                player.getZ(),
                                player
                        );

                        return 1;
                    }

                    // ❌ Refus d'accès
                    MsgtellrawautosendProcedure.execute(
                            player.level(),
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            Component.translatable("palamod.procedure.noperm").getString()
                    );

                    return 0;
                })
        );
    }
}