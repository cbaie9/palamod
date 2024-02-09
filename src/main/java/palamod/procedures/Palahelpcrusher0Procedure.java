package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher0Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Voici le crusher, la machine permettant";
		}
		return "This is the crusher, the machine who ";
	}
}
