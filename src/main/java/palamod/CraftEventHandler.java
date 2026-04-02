package palamod;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import palamod.procedures.JobCraftRestrictionManagerProcedure;

@EventBusSubscriber
public class CraftEventHandler {

    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {

        Player player = event.getEntity();
        ItemStack result = event.getCrafting();

        boolean allowed = JobCraftRestrictionManagerProcedure.canCraft(
                player.level(),
                player.getX(),
                player.getY(),
                player.getZ(),
                player,
                result
        );

        if (!allowed) {

            // Supprime le résultat
            result.setCount(0);

            // Restaure les ingrédients
            AbstractContainerMenu menu = player.containerMenu;

            if (menu instanceof CraftingMenu craftingMenu) {

                for (int i = 1; i <= 9; i++) {
                    Slot slot = craftingMenu.getSlot(i);

                    if (!slot.getItem().isEmpty()) {
                        slot.getItem().grow(1);
                    }
                }
            }
        }
    }
}