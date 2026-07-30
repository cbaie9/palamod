package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class ShowFromSlot1PalahelpJobsXpGainProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return ShowSlotPalahelpJobsXpGainLogicProcedure.execute(entity, 1);
	}
}