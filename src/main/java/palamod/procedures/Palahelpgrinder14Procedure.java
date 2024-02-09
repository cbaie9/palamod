package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgrinder14Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Fortune : Comme l'enchante, double ou triple les";
		}
		return "Fortune : Like the enchant, double or triple the ";
	}
}
