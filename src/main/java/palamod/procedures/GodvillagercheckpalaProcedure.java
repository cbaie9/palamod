package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import palamod.entity.GodvillagerEntity;

import palamod.PalamodMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class GodvillagercheckpalaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		PalamodMod.LOGGER.info("check pala god villager");
		if (0 == getAmountInGUISlot(entity, 1)
				&& 64 == getAmountInGUISlot(entity, 0) && PalamodModBlocks.PALADIUM_BLOCK.get()
						.asItem() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem()
				&& !(entity instanceof GodvillagerEntity _datEntL5 && _datEntL5.getEntityData().get(GodvillagerEntity.DATA_trade_used))) {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
				_setstack.setCount(1);
				((Slot) _slots.get(1)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof Supplier slotSupplier && slotSupplier.get() instanceof Map guiSlots) {
			ItemStack stack = ((Slot) guiSlots.get(sltid)).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}
