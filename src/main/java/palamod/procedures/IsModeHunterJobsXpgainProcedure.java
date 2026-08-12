package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class IsModeHunterJobsXpgainProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return ("hunter").equals(entity.getPersistentData().getString("jobs_mode"));
	}
}