package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpcrusher2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Le principe est simple, il faut melanger ";
		}
		return "The process is simple, you need to mix fuel";
	}
}
