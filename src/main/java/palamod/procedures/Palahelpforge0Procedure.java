package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpforge0Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "La forge est une machine permettant de recycler vos outils";
		}
		return "The forge is a machine witch allow to recycle your tools";
	}
}
