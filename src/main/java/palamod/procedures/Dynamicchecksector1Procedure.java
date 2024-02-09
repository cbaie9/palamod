package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Dynamicchecksector1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getY() < 150 && entity.getY() > 128) {
			return true;
		}
		return false;
	}
}
