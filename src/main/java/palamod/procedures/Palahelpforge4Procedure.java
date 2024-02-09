package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpforge4Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "armure et attender et c'est bon, c'est fini";
		}
		return "and ...it's done easy isn't ?";
	}
}
