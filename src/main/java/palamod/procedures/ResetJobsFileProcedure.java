package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.io.File;

public class ResetJobsFileProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File jobs = new File("");
		jobs = GetjobsfileProcedure.execute(entity);
		jobs.delete();
		JobsfilecreateautorepairProcedure.execute(world, entity);
	}
}