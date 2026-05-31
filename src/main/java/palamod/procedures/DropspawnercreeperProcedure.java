package palamod.procedures;

import net.neoforged.neoforge.event.level.ExplosionEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class DropspawnercreeperProcedure {
	@SubscribeEvent
	public static void onExplode(ExplosionEvent.Detonate event) {
		execute(event, event.getLevel(), event.getExplosion().center().x(), event.getExplosion().center().y(), event.getExplosion().center().z());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator.is(TagKey.create(Registries.ENTITY_TYPE, Identifier.parse("palamod:creeper")))) {
				}
			}
		}
	}
}