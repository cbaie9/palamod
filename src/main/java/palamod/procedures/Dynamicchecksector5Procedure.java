package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Dynamicchecksector5Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getY() < 15 && entity.getY() > -64) {
			return true;
		}
		return false;
	}
}
