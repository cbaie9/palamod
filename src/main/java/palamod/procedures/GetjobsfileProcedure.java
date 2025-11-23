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
		if (IsgameserversideProcedure.execute()) {
			output = ReadjobsserverProcedure.execute(entity);
			PalamodMod.LOGGER.debug("read server side jobs");
		} else if (IsgameclientsideProcedure.execute(world, x, y, z)) {
			output = ReadjobsclientProcedure.execute(world, entity);
			PalamodMod.LOGGER.debug("read client side jobs");
		} else {
			output = ReadjobsserverProcedure.execute(entity);
			PalamodMod.LOGGER.fatal("FATAL ERROR : jobs file don't exist");
		}
		return output;
	}
}