package palamod.item.inventory;

import palamod.init.PalamodModItems;

import palamod.client.gui.TrashguiScreen;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

import javax.annotation.Nonnull;

@EventBusSubscriber(Dist.CLIENT)
public class VoidstoneInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == PalamodModItems.VOIDSTONE.get()) {
			if (Minecraft.getInstance().screen instanceof TrashguiScreen) {
				Minecraft.getInstance().player.closeContainer();
			}
		}
	}

	public VoidstoneInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 1);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != PalamodModItems.VOIDSTONE.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}
