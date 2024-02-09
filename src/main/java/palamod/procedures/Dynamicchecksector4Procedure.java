package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Dynamicchecksector4Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getY() < 32 && entity.getY() > 15) {
			return true;
		}
		return false;
	}
}
