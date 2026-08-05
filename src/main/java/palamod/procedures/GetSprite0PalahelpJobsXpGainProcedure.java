package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class GetSprite0PalahelpJobsXpGainProcedure {
	public static double execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return 0;
		return GetSpriteNumGainJobsPalahelpProcedure.execute(world, entity, 0);
	}
}