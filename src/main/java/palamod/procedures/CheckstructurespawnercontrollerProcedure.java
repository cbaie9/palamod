package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CheckstructurespawnercontrollerProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean output = false;
		double num = 0;
		num = 1;
		for (int index0 = 0; index0 < 2; index0++) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z))).getBlock() == PalamodModBlocks.DIAMOND_INFUSED_OBSIDIAN.get() && (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x, y - 2, z + 1 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z + 1 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z + 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z + 1 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z + 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z + 1 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z + 1 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z + 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z + 2 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z + 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z + 2 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z + 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z + 3 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z + 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z + 3 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 3 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 3 * num))).getBlock() == Blocks.SOUL_SAND) {
				output = true;
				break;
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x, y - 2, z - 3 * num))).getBlock() == PalamodModBlocks.DIAMOND_INFUSED_OBSIDIAN.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z - 4 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x, y - 2, z - 5 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x, y - 2, z - 6 * num))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 3 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 4 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 5 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 6 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 3 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 4 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 5 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 6 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 3 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 4 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 5 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 3 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 4 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 5 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z - 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND) {
				output = true;
				break;
			}
			num = -1;
		}
		return output;
	}
}