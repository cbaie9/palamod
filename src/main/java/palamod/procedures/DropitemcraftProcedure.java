package palamod.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class DropitemcraftProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double idrop = 0;
		for (int index0 = 0; index0 < 9; index0++) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) idrop)).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount((int) idrop));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			idrop = idrop + 1;
		}
	}
}
