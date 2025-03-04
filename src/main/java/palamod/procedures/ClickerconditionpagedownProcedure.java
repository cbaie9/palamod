package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.level.LevelAccessor;

public class ClickerconditionpagedownProcedure {
	public static boolean execute(LevelAccessor world) {
		boolean exit = false;
		if (PalamodModVariables.MapVariables.get(world).clicker_page > 1 && PalamodModVariables.MapVariables.get(world).clicker_page <= 6) {
			exit = true;
		} else {
			exit = false;
		}
		return exit;
	}
}
