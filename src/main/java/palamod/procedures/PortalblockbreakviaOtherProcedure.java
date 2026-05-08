package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.LevelAccessor;

public class PortalblockbreakviaOtherProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		PortalblockbreakProcedure.execute(world, x, y, z, PalamodModBlocks.AMETHYST_PORTALBLOCK.get().defaultBlockState());
	}
}