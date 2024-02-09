package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher1Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "avec des fruits, de creer de l'endium";
		}
		return "permiter you to with fruits create endium";
	}
}
