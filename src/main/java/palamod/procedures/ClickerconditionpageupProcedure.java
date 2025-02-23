package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.level.LevelAccessor;

public class ClickerconditionpageupProcedure {
	public static boolean execute(LevelAccessor world) {
		boolean exit = false;
		if (PalamodModVariables.MapVariables.get(world).clicker_page >= 0 && PalamodModVariables.MapVariables.get(world).clicker_page < 5) {
			exit = true;
		} else {
			exit = false;
		}
		return exit;
	}
}
