package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher4Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "de l'endium. Vous pouvez inserer different ";
		}
		return "endium. For the fuel you can put different ";
	}
}
