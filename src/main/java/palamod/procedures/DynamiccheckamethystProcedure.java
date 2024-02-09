package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class DynamiccheckamethystProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getY() < 80 && entity.getY() > -64) {
			return true;
		}
		return false;
	}
}
