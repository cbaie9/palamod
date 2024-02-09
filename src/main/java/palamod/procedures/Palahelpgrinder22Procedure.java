package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder22Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Il vous faudra : 126 lingot de paladium et 40 lingot de titane";
		}
		return "You'll need : 126 ingots of paladium, 40 ingot of titane";
	}
}
