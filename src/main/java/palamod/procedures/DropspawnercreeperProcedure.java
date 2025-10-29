package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.event.level.ExplosionEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

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
				if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("palamod:creeper")))) {
					int horizontalRadiusSquare = (int) 4 - 1;
					int verticalRadiusSquare = (int) 4 - 1;
					int yIterationsSquare = verticalRadiusSquare;
					for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
						for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
							for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
								// Execute the desired statements within the square/cube
								if (Blocks.SPAWNER == (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock()) {
									world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
									if (Math.random() < 2d / 6) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x + xi, (0.25 + y + i), z + zi, new ItemStack(PalamodModBlocks.BROKENSPAWNER.get()));
											entityToSpawn.setPickUpDelay(10);
											entityToSpawn.setUnlimitedLifetime();
											_level.addFreshEntity(entityToSpawn);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}