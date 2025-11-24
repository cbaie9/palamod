package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.io.File;

public class GetjobsfileProcedure {
	public static File execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return new File("");
		File output = new File("");
		if (IsgameclientsideProcedure.execute(world, x, y, z)) {
			output = ReadjobsclientProcedure.execute(world, entity);
		} else if (IsgameserversideProcedure.execute()) {
			output = ReadjobsserverProcedure.execute(entity);
		} else {
			output = ReadjobsserverProcedure.execute(entity);
			PalamodMod.LOGGER.fatal("FATAL ERROR : jobs file don't exist");
		}
		return output;
	}
}