package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class ShowSlotPalahelpJobsXpGainLogicProcedure {
	public static boolean execute(Entity entity, double slot) {
		if (entity == null)
			return false;
		return !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get((int) slot).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem());
	}
}