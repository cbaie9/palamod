package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class MsgtellrawautosendProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		MsgtellrawautosendspecialselectorProcedure.execute(world, x, y, z, entity.getDisplayName().getString(), text);
	}
}