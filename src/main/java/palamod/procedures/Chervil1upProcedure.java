package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class Chervil1upProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.004 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.FARMLAND) {
			world.setBlock(BlockPos.containing(x, y, z), PalamodModBlocks.CHERVIL_2.get().defaultBlockState(), 3);
		} else if (Math.random() < 0.008 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == PalamodModBlocks.FERTILZED_DIRT.get()) {
			world.setBlock(BlockPos.containing(x, y, z), PalamodModBlocks.CHERVIL_2.get().defaultBlockState(), 3);
		}
	}
}