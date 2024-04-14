package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GetxpminerbreakblockProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double output = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.STONE) {
			output = 0.5;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIORITE) {
			output = 3;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.GRANITE) {
			output = 3;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ANDESITE) {
			output = 3;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.COAL_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_COAL_ORE) {
			output = 4;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHER_QUARTZ_ORE) {
			output = 6;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OBSIDIAN) {
			output = 6;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.REDSTONE_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.REDSTONE_ORE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_REDSTONE_ORE) {
			output = 15;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.EMERALD_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_EMERALD_ORE) {
			output = 75;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIAMOND_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE) {
			output = 25;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.FINDIUM_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_FINDIUM_ORE.get()) {
			output = 110;
		}
		return output;
	}
}
