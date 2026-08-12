package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class IsModeMinerJobsXpgainProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return ("miner").equals(entity.getPersistentData().getString("jobs_mode"));
	}
}