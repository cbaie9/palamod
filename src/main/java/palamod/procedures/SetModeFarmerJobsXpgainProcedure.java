package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class SetModeFarmerJobsXpgainProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("jobs_mode", "farmer");
	}
}