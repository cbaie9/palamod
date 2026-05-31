package palamod.item.inventory;

import palamod.world.inventory.PhoneguiMenu;

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
public class PaladiumphoneInventoryCapability extends ItemAccessItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == PalamodModItems.PALADIUM_PHONE.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof PhoneguiMenu)
				player.closeContainer();
		}
	}

	public PaladiumphoneInventoryCapability(ItemAccess access) {
		super(access, DataComponents.CONTAINER, 9);
	}

	@Override
	protected int getCapacity(int index, ItemResource resource) {
		return Math.min(64, super.getCapacity(index, resource));
	}

	@Override
	public boolean isValid(int index, ItemResource resource) {
		return super.isValid(index, resource) && resource.getItem() != PalamodModItems.PALADIUM_PHONE.get();
	}
}