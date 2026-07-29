package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.entity.Entity;

public class PageUpPalahelpJobsXpGainLogicProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(PalamodModItems.LUCKY_BETA.get() == GetItemPalahelpJobsXpgainProcedure.execute(entity, true, 6).getItem());
	}
}