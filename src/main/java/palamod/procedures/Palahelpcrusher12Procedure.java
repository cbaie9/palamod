package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher12Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Note : vous n'\u00EAtes pas obliger d'ins\u00E9r\u00E9 128 de chaque mais il aura une chance";
		}
		return "Note : it's not mandatory to put 128 fruit and fuel in the crusher but there is";
	}
}
