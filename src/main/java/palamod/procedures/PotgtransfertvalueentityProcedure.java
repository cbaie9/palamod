package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class PotgtransfertvalueentityProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getDoubleOr("Pickaxe_stone", 0) > 0) {
			if ((entity.getPersistentData().getStringOr("language", "")).equals("french")) {
				return "Xp actuel de joueur :" + entity.getPersistentData().getDoubleOr("Pickaxe_stone", 0);
			} else {
				return "Actual player Xp :" + entity.getPersistentData().getDoubleOr("Pickaxe_stone", 0);
			}
		}
		return "The xp level of the potg must be superior to 0";
	}
}