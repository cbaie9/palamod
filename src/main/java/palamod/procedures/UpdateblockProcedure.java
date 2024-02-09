package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class UpdateblockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		PalamodMod.queueServerWork(20, () -> {
			world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), 1);
			world.scheduleTick(BlockPos.containing(x, y + 1, z), world.getBlockState(BlockPos.containing(x, y + 1, z)).getBlock(), 1);
			world.scheduleTick(BlockPos.containing(x, y - 1, z), world.getBlockState(BlockPos.containing(x, y - 1, z)).getBlock(), 1);
			world.scheduleTick(BlockPos.containing(x + 1, y, z), world.getBlockState(BlockPos.containing(x + 1, y, z)).getBlock(), 1);
			world.scheduleTick(BlockPos.containing(x - 1, y, z), world.getBlockState(BlockPos.containing(x - 1, y, z)).getBlock(), 1);
			world.scheduleTick(BlockPos.containing(x, y, z - 1), world.getBlockState(BlockPos.containing(x, y, z - 1)).getBlock(), 1);
			world.scheduleTick(BlockPos.containing(x, y, z + 1), world.getBlockState(BlockPos.containing(x, y, z + 1)).getBlock(), 1);
		});
	}
}
