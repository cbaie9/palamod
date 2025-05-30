package palamod.procedures;

import palamod.entity.PaladiumgolemEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class GuardianentityproviderProcedure {
	public static Entity execute(LevelAccessor world, double x, double y, double z) {
		return findEntityInWorldRange(world, PaladiumgolemEntity.class, x, y, z, 4);
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}
