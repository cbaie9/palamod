package palamod.item.inventory;

import palamod.world.inventory.TrashguiMenu;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemAccessItemHandler;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.core.component.DataComponents;

@EventBusSubscriber
public class VoidstoneInventoryCapability extends ItemAccessItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == PalamodModItems.VOIDSTONE.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof TrashguiMenu)
				player.closeContainer();
		}
	}

	public VoidstoneInventoryCapability(ItemAccess access) {
		super(access, DataComponents.CONTAINER, 1);
	}

	@Override
	protected int getCapacity(int index, ItemResource resource) {
		return Math.min(64, super.getCapacity(index, resource));
	}

	@Override
	public boolean isValid(int index, ItemResource resource) {
		return super.isValid(index, resource) && resource.getItem() != PalamodModItems.VOIDSTONE.get();
	}
}