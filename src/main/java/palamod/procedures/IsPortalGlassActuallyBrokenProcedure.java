package palamod.procedures;

import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class IsPortalGlassActuallyBrokenProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, String position) {
		if (position == null)
			return false;
		boolean output = false;
		BlockState portal = Blocks.AIR.defaultBlockState();
		portal = PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState();
		if ((position).equals("east")) {
			if (!((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x + 3, y, z + 1))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x + 3, y, z - 1))).getBlock() == portal.getBlock())) {
				output = true;
			}
		} else if ((position).equals("west")) {
			if (!((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x - 2, y, z + 1))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x - 3, y, z + 1))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x - 3, y, z - 1))).getBlock() == portal.getBlock())) {
				output = true;
			}
		} else if ((position).equals("north")) {
			if (!((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x + 1, y, z - 3))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x, y, z - 3))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x - 1, y, z - 3))).getBlock() == portal.getBlock())) {
				output = true;
			}
		} else if ((position).equals("south")) {
			if (!((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x + 1, y, z + 3))).getBlock() == portal.getBlock()) || !((world.getBlockState(BlockPos.containing(x, y, z + 3))).getBlock() == portal.getBlock())
					|| !((world.getBlockState(BlockPos.containing(x - 1, y, z + 3))).getBlock() == portal.getBlock())) {
				output = true;
			}
		} else {
			PalamodMod.LOGGER.error("[from : IsPortalGlassActuallyBroken] Invalid use of method  : position must be in these 4 values [ north | south | east | west ]");
		}
		PalamodMod.LOGGER.debug(("[from : IsPortalGlassActuallyBroken] output : " + output));
		return output;
	}
}