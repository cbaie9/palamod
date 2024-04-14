package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GetxpminerbreakblocklogicProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean output = false;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.STONE) {
			output = true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIORITE) {
			output = true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.GRANITE) {
			output = true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ANDESITE) {
			output = true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.COAL_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_COAL_ORE) {
			output = true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHER_QUARTZ_ORE) {
			output = true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OBSIDIAN) {
			output = true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.REDSTONE_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.REDSTONE_ORE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_REDSTONE_ORE) {
			output = true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.EMERALD_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_EMERALD_ORE) {
			output = true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIAMOND_ORE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE) {
			output = true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.FINDIUM_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_FINDIUM_ORE.get()) {
			output = true;
		} else {
			output = false;
		}
		return output;
	}
}
