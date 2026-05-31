package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;

public class CauldronbreakProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		CauldronmanagerprocessProcedure.execute(world, x, y, z, "break");
	}
}