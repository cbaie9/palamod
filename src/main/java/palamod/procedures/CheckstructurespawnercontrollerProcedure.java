package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CheckstructurespawnercontrollerProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean output = false;
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 2, z))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 2, y - 2, z))).getBlock() == Blocks.OBSIDIAN
				&& (world.getBlockState(BlockPos.containing(x - 3, y - 2, z))).getBlock() == PalamodModBlocks.DIAMOND_INFUSED_OBSIDIAN.get() && (world.getBlockState(BlockPos.containing(x - 4, y - 2, z))).getBlock() == Blocks.OBSIDIAN
				&& (world.getBlockState(BlockPos.containing(x - 5, y - 2, z))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 6, y - 2, z))).getBlock() == Blocks.OBSIDIAN
				&& (world.getBlockState(BlockPos.containing(x, y - 2, z + 1))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 1, y - 2, z + 1))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(BlockPos.containing(x - 2, y - 2, z + 1))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 3, y - 2, z + 1))).getBlock() == Blocks.OBSIDIAN
				&& (world.getBlockState(BlockPos.containing(x - 4, y - 2, z + 1))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 5, y - 2, z + 1))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(BlockPos.containing(x - 6, y - 2, z + 1))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x, y - 2, z - 1))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 2, z - 1))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 2, y - 2, z - 1))).getBlock() == Blocks.OBSIDIAN
				&& (world.getBlockState(BlockPos.containing(x - 3, y - 2, z - 1))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 4, y - 2, z - 1))).getBlock() == Blocks.OBSIDIAN
				&& (world.getBlockState(BlockPos.containing(x - 5, y - 2, z - 1))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 6, y - 2, z - 1))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 2, z + 2))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 2, y - 2, z + 2))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(BlockPos.containing(x - 3, y - 2, z + 2))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 4, y - 2, z + 2))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(BlockPos.containing(x - 5, y - 2, z + 2))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 1, y - 2, z - 2))).getBlock() == Blocks.OBSIDIAN
				&& (world.getBlockState(BlockPos.containing(x - 2, y - 2, z - 2))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 3, y - 2, z - 2))).getBlock() == Blocks.OBSIDIAN
				&& (world.getBlockState(BlockPos.containing(x - 4, y - 2, z - 2))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 5, y - 2, z - 2))).getBlock() == Blocks.OBSIDIAN
				&& (world.getBlockState(BlockPos.containing(x - 2, y - 2, z + 3))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 3, y - 2, z + 3))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
				&& (world.getBlockState(BlockPos.containing(x - 4, y - 2, z + 3))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 2, y - 2, z - 3))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(BlockPos.containing(x - 3, y - 2, z - 3))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get() && (world.getBlockState(BlockPos.containing(x - 2, y - 2, z - 3))).getBlock() == Blocks.SOUL_SAND) {
			output = true;
		} else if (false) {
			output = true;
		} else if (false) {
			output = true;
		} else if (false) {
			output = true;
		} else {
			output = false;
		}
		return output;
	}
}