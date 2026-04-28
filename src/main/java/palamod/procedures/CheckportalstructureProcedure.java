package palamod.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CheckportalstructureProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState angle_block_dep, BlockState shiny_wood_dep) {
		BlockState angle_block = Blocks.AIR.defaultBlockState();
		BlockState shiny_wood = Blocks.AIR.defaultBlockState();
		angle_block = angle_block_dep;
		shiny_wood = shiny_wood_dep;
		if ((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == angle_block.getBlock()
				&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == shiny_wood.getBlock()) {
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z + 2))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 3, y, z + 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 2, y, z - 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 3, y, z - 2))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 4, y, z - 2))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x - 4, y, z + 2))).getBlock() == angle_block.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 4, y, z))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 4, y, z + 1))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 4, y, z - 1))).getBlock() == shiny_wood.getBlock()) {
				return true;
			} else if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x + 4, y, z - 2))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x + 4, y, z + 2))).getBlock() == angle_block.getBlock()
					&& (world.getBlockState(BlockPos.containing(x + 4, y, z))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 4, y, z + 1))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x + 4, y, z - 1))).getBlock() == shiny_wood.getBlock()) {
				return true;
			}
		} else if ((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == angle_block.getBlock()
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == shiny_wood.getBlock()) {
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x + 2, y, z - 3))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 2, y, z - 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z - 3))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 2, y, z - 4))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y, z - 4))).getBlock() == angle_block.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 4, y, z))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 1, y, z - 4))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 4))).getBlock() == shiny_wood.getBlock()) {
				return true;
			} else if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x + 2, y, z + 3))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z + 1))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 2, y, z + 2))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x - 2, y, z + 3))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 2, y, z + 4))).getBlock() == angle_block.getBlock() && (world.getBlockState(BlockPos.containing(x + 2, y, z + 4))).getBlock() == angle_block.getBlock()
					&& (world.getBlockState(BlockPos.containing(x + 4, y, z))).getBlock() == shiny_wood.getBlock() && (world.getBlockState(BlockPos.containing(x + 1, y, z + 4))).getBlock() == shiny_wood.getBlock()
					&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 4))).getBlock() == shiny_wood.getBlock()) {
				return true;
			}
		}
		return false;
	}
}