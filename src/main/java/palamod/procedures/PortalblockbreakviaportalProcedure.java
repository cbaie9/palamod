package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class PortalblockbreakviaportalProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double y_core = 0;
		double x_core = 0;
		double z_core = 0;
		double loop = 0;
		BlockState active = Blocks.AIR.defaultBlockState();
		BlockState shiny_wood = Blocks.AIR.defaultBlockState();
		BlockState angle_block = Blocks.AIR.defaultBlockState();
		ItemStack key = ItemStack.EMPTY;
		boolean pass = false;
		boolean master_check = false;
		PortalblockbreakProcedure.execute(world, x, y, z, PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState());
	}
}