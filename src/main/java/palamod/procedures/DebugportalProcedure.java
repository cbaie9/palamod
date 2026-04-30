package palamod.procedures;

import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;

public class DebugportalProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		PalamodMod.LOGGER.info(("portal :" + CheckportalstructureProcedure.execute(world, x, y, z, PalamodModBlocks.AMETHYST_BLOCK.get().defaultBlockState(), PalamodModBlocks.SHINY_JACARANDA_WOOD.get().defaultBlockState())));
	}
}