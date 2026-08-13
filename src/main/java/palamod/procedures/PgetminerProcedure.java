package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class PgetminerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		MsgtellrawautosendProcedure.execute(world, x, y, z, entity, ClientSideGetLevelJobsProcedure.execute(world, x, y, z, entity));
	}
}