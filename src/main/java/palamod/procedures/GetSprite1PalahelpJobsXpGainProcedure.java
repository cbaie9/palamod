package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class GetSprite1PalahelpJobsXpGainProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getPersistentData().getDouble("xpgain_getSpriteNum_1");
	}
}