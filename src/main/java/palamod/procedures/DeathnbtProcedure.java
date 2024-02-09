package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class DeathnbtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("Palamod.alive")) {
			entity.getPersistentData().putBoolean("Palamod.alive", false);
		}
	}
}
