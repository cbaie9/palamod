package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class PalamachineoxcheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBooleanOr("debug_pala", false)) {
			return true;
		}
		return false;
	}
}