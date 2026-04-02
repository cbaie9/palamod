package palamod.procedures;

import net.minecraft.world.entity.Entity;

import java.io.File;

public class GetjobsfileProcedure {
	public static File execute(Entity entity) {
		if (entity == null)
			return new File("");
		File output = new File("");
		return ReadjobsserverProcedure.execute(entity);
	}
}