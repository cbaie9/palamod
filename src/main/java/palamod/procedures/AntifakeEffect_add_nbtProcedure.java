package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class AntifakeEffect_add_nbtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("antifake", true);
	}
}
