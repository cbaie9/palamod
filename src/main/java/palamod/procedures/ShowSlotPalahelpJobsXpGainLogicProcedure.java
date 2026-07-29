package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class ShowSlotPalahelpJobsXpGainLogicProcedure {
	public static boolean execute(Entity entity, double slot) {
		if (entity == null)
			return false;
		return !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get((int) slot).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.LUCKY_BETA.get());
	}
}