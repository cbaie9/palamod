package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OxmodsreturnverProcedure {
	public static String execute(LevelAccessor world) {
		return "The actual installed version is :" + PalamodgameverProcedure.execute(world);
	}
}
