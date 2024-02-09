package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Grindergui_hGo_adv_checkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("hGo_adv", true);
	}
}
