package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Dynamicchecksector3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getY() < 80 && entity.getY() > 32) {
			return true;
		}
		return false;
	}
}
