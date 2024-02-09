package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder11Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "certains outils dont le hammer, la fastsword";
		}
		return "some tools like the hammer, the fastsword";
	}
}
