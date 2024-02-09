package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class PotgtransfertvalueentityProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getDouble("Pickaxe_stone") > 0) {
			if ((entity.getPersistentData().getString("language")).equals("french")) {
				return "Xp actuel de joueur :" + entity.getPersistentData().getDouble("Pickaxe_stone");
			} else {
				return "Actual player Xp :" + entity.getPersistentData().getDouble("Pickaxe_stone");
			}
		}
		return "The xp level of the potg must be superior to 0";
	}
}
