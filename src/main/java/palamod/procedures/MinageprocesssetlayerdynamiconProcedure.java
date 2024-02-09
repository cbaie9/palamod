package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class MinageprocesssetlayerdynamiconProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("Minage_setlayer_dynamic", true);
		entity.getPersistentData().putBoolean("Minage_setlayer", false);
	}
}
