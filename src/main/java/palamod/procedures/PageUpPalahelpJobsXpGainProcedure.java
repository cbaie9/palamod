package palamod.procedures;

import palamod.init.PalamodModItems;

import palamod.PalamodMod;

import net.minecraft.world.entity.Entity;

public class PageUpPalahelpJobsXpGainProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		PalamodMod.LOGGER.debug("[PageUpPalahelpJobsXpGain] : Trying to slide index +1, may print error on border");
		if (!(PalamodModItems.LUCKY_BETA.get() == GetItemPalahelpJobsXpgainProcedure.execute(entity, false, 6).getItem())) {
			entity.getPersistentData().putDouble("indexSlider", (1 + entity.getPersistentData().getDouble("indexSlider")));
			FillSlotPalahelpXpGainProcedure.execute(entity);
		}
	}
}