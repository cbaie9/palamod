package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelppalamachine2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "effets different ( force, saut, sante etc )";
		}
		return "( strenght, heal, jump, damage and speed)";
	}
}
