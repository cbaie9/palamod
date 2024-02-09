package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

public class Paladiumdynamite_boomProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		PalamodMod.queueServerWork(100, () -> {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 8, Level.ExplosionInteraction.TNT);
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
