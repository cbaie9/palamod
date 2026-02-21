package palamod;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import palamod.procedures.JobCraftRestrictionManagerProcedure;

@EventBusSubscriber
public class CraftEventHandler {

    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {

        Player player = event.getEntity();
        ItemStack result = event.getCrafting();

        if (!JobCraftRestrictionManagerProcedure.canCraft(
                player.level(),
                player.getX(),
                player.getY(),
                player.getZ(),
                player,
                result
        )) {
            result.setCount(0);
        }
    }
}