package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;

public class DebugcheckstructurespawnercontrollerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		PalamodMod.LOGGER.debug(("Spawner controller :" + CheckstructurespawnercontrollerProcedure.execute(world, x, y, z)));
	}
}