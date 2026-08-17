package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CheckstructurespawnercontrollerProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double num = 0;
		double output = 0;
		num = 1;
		for (int index1173 = 0; index1173 < 2; index1173++) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z))).getBlock() == PalamodModBlocks.DIAMOND_INFUSED_OBSIDIAN.get() && (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x, y - 2, z + 1 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z + 1 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z + 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z + 1 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z + 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z + 1 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z + 1 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z + 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z + 2 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z + 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z + 2 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z + 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z + 3 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z + 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z + 3 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 3 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 3 * num))).getBlock() == Blocks.SOUL_SAND) {
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 3 * num))).getBlock() == PalamodModBlocks.AMETHYST_INFUSED_OBSIDIAN.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z - 3 * num))).getBlock() == Blocks.OBSIDIAN
						&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 3 * num))).getBlock() == PalamodModBlocks.AMETHYST_INFUSED_OBSIDIAN.get()
						&& (world.getBlockState(BlockPos.containing(x, y - 2, z + 3 * num))).getBlock() == Blocks.OBSIDIAN
						&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 1, z + 3 * num))).getBlock() == PalamodModBlocks.AMETHYST_INFUSED_OBSIDIAN.get()
						&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z + 3 * num))).getBlock() == Blocks.OBSIDIAN
						&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 1, z - 3 * num))).getBlock() == PalamodModBlocks.AMETHYST_INFUSED_OBSIDIAN.get()
						&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z - 3 * num))).getBlock() == Blocks.OBSIDIAN) {
					if ((world.getBlockState(BlockPos.containing(x + 2 * num, y - 1, z - 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x + 2 * num, y, z - 2 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x + 2 * num, y - 1, z + 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z + 2 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x + 2 * num, y, z + 2 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 1 * num, y, z - 5 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 1, z - 5 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 5 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x - 1 * num, y, z + 5 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 1, z + 5 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z + 5 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x - 5 * num, y, z + 5 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 5 * num, y - 1, z + 5 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z + 5 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x - 5 * num, y, z - 5 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 5 * num, y - 1, z - 5 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z - 5 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x - 8 * num, y, z + 2 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 8 * num, y - 1, z + 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 8 * num, y - 2, z + 2 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x - 8 * num, y, z - 2 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 8 * num, y - 1, z - 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 8 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN) {
						if ((world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z - 4 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 3 * num, y - 1, z - 4 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y, z - 4 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y + 1, z - 4 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z - 6 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 3 * num, y - 1, z - 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y, z - 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y + 1, z - 6 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 6 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 1 * num, y - 1, z - 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 1 * num, y, z - 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 1 * num, y + 1, z - 6 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z + 6 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 1 * num, y - 1, z + 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 1 * num, y, z + 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 1 * num, y + 1, z + 6 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z + 6 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 3 * num, y - 1, z + 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y, z + 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y + 1, z + 6 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z + 4 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 3 * num, y - 1, z + 4 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y, z + 4 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 3 * num, y + 1, z + 4 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 7 * num, y - 2, z + 6 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 7 * num, y - 1, z + 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 7 * num, y, z + 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 7 * num, y + 1, z + 6 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y - 2, z + 6 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 9 * num, y - 1, z + 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y, z + 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y + 1, z + 6 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y - 2, z + 4 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 9 * num, y - 1, z + 4 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y, z + 4 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y + 1, z + 4 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y - 2, z - 4 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 9 * num, y - 1, z - 4 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y, z - 4 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y + 1, z - 4 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y - 2, z - 6 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 9 * num, y - 1, z - 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y, z - 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 9 * num, y + 1, z - 6 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 7 * num, y - 2, z - 6 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 7 * num, y - 1, z - 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 7 * num, y, z - 6 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 7 * num, y + 1, z - 6 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()) {
							output = 4;
						} else {
							output = 3;
						}
					} else {
						output = 2;
					}
				} else {
					output = 1;
				}
				break;
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x, y - 2, z - 3 * num))).getBlock() == PalamodModBlocks.DIAMOND_INFUSED_OBSIDIAN.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z - 4 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x, y - 2, z - 5 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x, y - 2, z - 6 * num))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 3 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 4 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 5 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 1 * num, y - 2, z - 6 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 1 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 2 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 3 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 4 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 5 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 1 * num, y - 2, z - 6 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 3 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 4 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 5 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 3 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 4 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 5 * num))).getBlock() == Blocks.OBSIDIAN
					&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z - 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_BLOCK.get()
					&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 2 * num))).getBlock() == Blocks.SOUL_SAND) {
				if ((world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 3 * num, y - 1, z))).getBlock() == PalamodModBlocks.AMETHYST_INFUSED_OBSIDIAN.get()
						&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z))).getBlock() == Blocks.OBSIDIAN
						&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 1, z))).getBlock() == PalamodModBlocks.AMETHYST_INFUSED_OBSIDIAN.get()
						&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 2, z - 6 * num))).getBlock() == Blocks.OBSIDIAN
						&& (world.getBlockState(BlockPos.containing(x + 3 * num, y - 1, z - 6 * num))).getBlock() == PalamodModBlocks.AMETHYST_INFUSED_OBSIDIAN.get()
						&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 2, z - 6 * num))).getBlock() == Blocks.OBSIDIAN
						&& (world.getBlockState(BlockPos.containing(x - 3 * num, y - 1, z - 6 * num))).getBlock() == PalamodModBlocks.AMETHYST_INFUSED_OBSIDIAN.get()) {
					if ((world.getBlockState(BlockPos.containing(x - 2 * num, y - 1, z + 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z + 2 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x - 2 * num, y, z + 2 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x + 2 * num, y - 1, z + 2 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z + 2 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x + 2 * num, y, z + 2 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 5 * num, y, z - 1 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 5 * num, y - 1, z - 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x + 5 * num, y, z - 1 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x + 5 * num, y - 1, z - 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 5 * num, y - 2, z - 1 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x + 5 * num, y, z - 5 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x + 5 * num, y - 1, z - 5 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 5 * num, y - 2, z - 5 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x - 5 * num, y, z - 5 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 5 * num, y - 1, z - 5 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 5 * num, y - 2, z - 5 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x + 2 * num, y, z - 8 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x + 2 * num, y - 1, z - 8 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 2 * num, y - 2, z - 8 * num))).getBlock() == Blocks.OBSIDIAN
							&& (world.getBlockState(BlockPos.containing(x - 2 * num, y, z - 8 * num))).getBlock() == PalamodModBlocks.TITANE_INFUSED_OBSIDIAN.get()
							&& (world.getBlockState(BlockPos.containing(x - 2 * num, y - 1, z - 8 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 2 * num, y - 2, z - 8 * num))).getBlock() == Blocks.OBSIDIAN) {
						if ((world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z + 3 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 4 * num, y - 1, z + 3 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 4 * num, y, z + 3 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 4 * num, y + 1, z + 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z + 3 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 6 * num, y - 1, z + 3 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y, z + 3 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y + 1, z + 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z + 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 6 * num, y - 1, z + 1 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y, z + 1 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y + 1, z + 1 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x + 4 * num, y - 2, z + 3 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 4 * num, y - 1, z + 3 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 4 * num, y, z + 3 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 4 * num, y + 1, z + 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z + 3 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 6 * num, y - 1, z + 3 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y, z + 3 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y + 1, z + 3 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y - 2, z + 1 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 6 * num, y - 1, z + 1 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y, z + 1 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y + 1, z - 7 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y - 2, z - 7 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 6 * num, y - 1, z - 7 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y, z - 7 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y + 1, z - 7 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y - 2, z - 9 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 6 * num, y - 1, z - 9 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y, z - 9 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 6 * num, y + 1, z - 9 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x + 4 * num, y - 2, z - 9 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 4 * num, y - 1, z - 9 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 4 * num, y, z - 9 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x + 4 * num, y + 1, z - 9 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 4 * num, y - 2, z - 9 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 4 * num, y - 1, z - 9 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 4 * num, y, z - 9 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 4 * num, y + 1, z - 9 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z - 9 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 6 * num, y - 1, z - 9 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y, z - 9 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y + 1, z - 9 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y - 2, z - 7 * num))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x - 6 * num, y - 1, z - 7 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y, z - 7 * num))).getBlock() == Blocks.OBSIDIAN
								&& (world.getBlockState(BlockPos.containing(x - 6 * num, y + 1, z - 7 * num))).getBlock() == PalamodModBlocks.PALADIUM_INFUSED_OBSIDIAN.get()) {
							output = 4;
						} else {
							output = 3;
						}
					} else {
						output = 2;
					}
				} else {
					output = 1;
				}
				break;
			}
			num = -1;
		}
		return output;
	}
}