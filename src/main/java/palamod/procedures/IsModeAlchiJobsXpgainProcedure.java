package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class IsModeAlchiJobsXpgainProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return ("alchi").equals(entity.getPersistentData().getString("jobs_mode"));
	}
}