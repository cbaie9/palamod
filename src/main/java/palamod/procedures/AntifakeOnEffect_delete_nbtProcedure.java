package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class AntifakeOnEffect_delete_nbtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("antifake", false);
	}
}
