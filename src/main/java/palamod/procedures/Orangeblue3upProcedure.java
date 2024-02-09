package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class Orangeblue3upProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (new Random().nextInt(125 + 1) == 1 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.FARMLAND) {
			world.setBlock(BlockPos.containing(x, y, z), PalamodModBlocks.ORANGEBLUE_4.get().defaultBlockState(), 3);
		}
	}
}
