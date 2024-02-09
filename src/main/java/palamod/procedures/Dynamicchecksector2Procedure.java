package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Dynamicchecksector2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getY() < 128 && entity.getY() > 80) {
			return true;
		}
		return false;
	}
}
