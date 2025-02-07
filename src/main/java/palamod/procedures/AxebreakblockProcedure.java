package palamod.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class AxebreakblockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		int horizontalRadiusSquare = (int) 5 - 1;
		int verticalRadiusSquare = (int) 10 - 1;
		int yIterationsSquare = verticalRadiusSquare;
		for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
			for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
				for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
					// Execute the desired statements within the square/cube
					if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
						world.levelEvent(2001, BlockPos.containing(x + xi, y + i + 0.75, z + zi), Block.getId((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)))));
						{
							BlockPos _pos = BlockPos.containing(x + xi, y + i, z + zi);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xi, y + i + 0.75, z + zi), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
		}
	}
}
