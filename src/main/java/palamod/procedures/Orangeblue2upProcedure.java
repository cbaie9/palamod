package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class Orangeblue2upProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.01125 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.FARMLAND) {
			world.setBlock(BlockPos.containing(x, y, z), PalamodModBlocks.ORANGEBLUE_3.get().defaultBlockState(), 3);
		}
	}
}
