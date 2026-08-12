package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class IsModeFarmerJobsXpgainProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return ("farmer").equals(entity.getPersistentData().getString("jobs_mode"));
	}
}