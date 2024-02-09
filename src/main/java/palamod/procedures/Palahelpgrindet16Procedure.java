package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrindet16Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Smelt : Cuit les minerais min\u00E9s -> hammer";
		}
		return "Smelt : Smelt the mined ores -> hammer";
	}
}
