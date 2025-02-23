package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.level.LevelAccessor;

public class ClickerpageupProcedure {
	public static void execute(LevelAccessor world) {
		if (PalamodModVariables.MapVariables.get(world).clicker_page >= 0 && PalamodModVariables.MapVariables.get(world).clicker_page < 6) {
			PalamodModVariables.MapVariables.get(world).clicker_page = PalamodModVariables.MapVariables.get(world).clicker_page + 1;
			PalamodModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
