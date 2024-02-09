package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class MinageprocessdynamicchecknbtProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getPersistentData().getBoolean("Minage_setlayer_dynamic");
	}
}
