package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TrixiumsetupProcedure {
	public static void execute(LevelAccessor world) {
		if (!((world.getBlockState(new BlockPos(0, 11, 0))).getBlock() == PalamodModBlocks.TRIXIUM_NBT_BLOCK.get())) {
			world.setBlock(new BlockPos(0, 11, 0), PalamodModBlocks.TRIXIUM_NBT_BLOCK.get().defaultBlockState(), 3);
		}
	}
}
