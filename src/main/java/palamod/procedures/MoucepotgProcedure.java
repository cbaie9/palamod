package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class MoucepotgProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double pickaxe_stone = 0;
		double level = 0;
		double xp_needed_current = 0;
		String tooltip = "";
		MoucePogProcessProcedure.execute(entity, false);
	}
}