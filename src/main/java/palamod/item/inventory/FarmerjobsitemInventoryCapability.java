package palamod.item.inventory;

import palamod.world.inventory.JobsfarmercraftguiMenu;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nonnull;

@EventBusSubscriber
public class FarmerjobsitemInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == PalamodModItems.FARMERJOBSITEM.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof JobsfarmercraftguiMenu)
				player.closeContainer();
		}
	}

	public FarmerjobsitemInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 10);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != PalamodModItems.FARMERJOBSITEM.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}