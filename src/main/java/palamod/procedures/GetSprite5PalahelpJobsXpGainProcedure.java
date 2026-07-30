package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class GetSprite5PalahelpJobsXpGainProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return GetSpriteNumGainJobsPalahelpProcedure.execute(entity, 5);
	}
}