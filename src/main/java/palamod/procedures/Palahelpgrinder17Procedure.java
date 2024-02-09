package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder17Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Speed : Booste la vitesse de minage -> hammer";
		}
		return "Speed : Boost the mining speed -> hammer";
	}
}
