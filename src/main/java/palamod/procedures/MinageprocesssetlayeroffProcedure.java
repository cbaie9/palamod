package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class MinageprocesssetlayeroffProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("Minage_setlayer_dynamic", false);
		entity.getPersistentData().putBoolean("Minage_setlayer", false);
	}
}
