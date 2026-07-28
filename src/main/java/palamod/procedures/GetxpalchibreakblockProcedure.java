package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;

public class GetxpalchibreakblockProcedure {
	public static double execute(BlockState blockDep, double level_alchimist) {
		double output = 0;
		double lvl = 0;
		BlockState block = Blocks.AIR.defaultBlockState();
		lvl = level_alchimist;
		block = blockDep;
		if ((block.getBlock() == PalamodModBlocks.OSTRYA_WOOD_WOOD.get() || block.getBlock() == PalamodModBlocks.OSTRYA_WOOD_LOG.get()) && lvl >= 50) {
			output = 50;
		} else if (block.getBlock() == PalamodModBlocks.JACARANDA_LOG.get() || block.getBlock() == PalamodModBlocks.JACARANDA_WOOD.get()) {
			output = 10;
		} else if (block.getBlock() == PalamodModBlocks.JUDEECERCIS_WOOD.get() || block.getBlock() == PalamodModBlocks.JUDEECERCIS_LOG.get()) {
			output = 10;
		} else if (block.getBlock() == PalamodModBlocks.ERABLE_LOG.get() || block.getBlock() == PalamodModBlocks.ERABLE_WOOD.get()) {
			output = 10;
		}
		return output;
	}
}