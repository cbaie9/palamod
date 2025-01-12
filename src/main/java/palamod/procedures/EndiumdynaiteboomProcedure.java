package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class EndiumdynaiteboomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		PalamodMod.queueServerWork(100, () -> {
			int horizontalRadiusSquare = (int) 16 - 1;
			int verticalRadiusSquare = (int) 16 - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("palamod:unbreakable_explosion")))) {
							if (Math.random() < 0.7) {
								{
									BlockPos _pos = BlockPos.containing(x + xi, y + i, z + zi);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xi, y + i, z + zi), null);
									world.destroyBlock(_pos, false);
								}
							} else {
								world.destroyBlock(BlockPos.containing(x + xi, y + i, z + zi), false);
							}
						}
					}
				}
			}
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 16, Level.ExplosionInteraction.TNT);
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
