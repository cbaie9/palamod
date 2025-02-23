package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.level.LevelAccessor;

public class ClickergetpagenumProcedure {
	public static double execute(LevelAccessor world) {
		return PalamodModVariables.MapVariables.get(world).clicker_page;
	}
}
