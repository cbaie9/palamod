package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.entity.Entity;

public class PageDownPalahelpJobsXpGainProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(PalamodModItems.LUCKY_BETA.get() == GetItemPalahelpJobsXpgainProcedure.execute(entity, true, -1).getItem())) {
			entity.getPersistentData().putDouble("indexSlider", (entity.getPersistentData().getDouble("indexSlider") - 1));
			FillSlotPalahelpXpGainProcedure.execute(entity);
		}
	}
}