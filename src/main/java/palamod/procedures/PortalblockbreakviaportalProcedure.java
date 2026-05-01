package palamod.procedures;

import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class PortalblockbreakviaportalProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean pass = false;
		double y_core = 0;
		double x_core = 0;
		double z_core = 0;
		double loop = 0;
		BlockState active = Blocks.AIR.defaultBlockState();
		BlockState shiny_wood = Blocks.AIR.defaultBlockState();
		BlockState angle_block = Blocks.AIR.defaultBlockState();
		for (int index0 = 0; index0 < 4; index0++) {
			if (loop == 0) {
				active = PalamodModBlocks.AMETHYST_PORTALBLOCK.get().defaultBlockState();
				shiny_wood = PalamodModBlocks.SHINY_JACARANDA_WOOD.get().defaultBlockState();
				angle_block = PalamodModBlocks.AMETHYST_BLOCK.get().defaultBlockState();
			} else if (loop == 1) {
				active = PalamodModBlocks.TITANE_PORTAL_BLOCK.get().defaultBlockState();
				shiny_wood = PalamodModBlocks.SHINY_JUDEECERCIS_WOOD.get().defaultBlockState();
				angle_block = PalamodModBlocks.TITANE_BLOCK.get().defaultBlockState();
			} else if (loop == 2) {
				active = PalamodModBlocks.PALADIUM_PORTAL_BLOCK.get().defaultBlockState();
				shiny_wood = PalamodModBlocks.SHINY_ERABLE_WOOD.get().defaultBlockState();
				angle_block = PalamodModBlocks.PALADIUM_BLOCK.get().defaultBlockState();
			} else if (loop == 3) {
				active = PalamodModBlocks.ENDIUM_PORTAL_BLOCK.get().defaultBlockState();
				shiny_wood = PalamodModBlocks.SHINY_OSTRYA_WOOD.get().defaultBlockState();
				angle_block = PalamodModBlocks.ENDIUM_PORTAL_ANGLE_BLOCK.get().defaultBlockState();
			}
			int horizontalRadiusHemiBot = (int) 5 - 1;
			int verticalRadiusHemiBot = (int) 2;
			int yIterationsHemiBot = verticalRadiusHemiBot;
			for (int i = -yIterationsHemiBot; i <= 0; i++) {
				if (i == -verticalRadiusHemiBot) {
					continue;
				}
				for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
					for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
								+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
						if (distanceSq <= 1.0) {
							if (active.getBlock() == (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock()) {
								x_core = x + xi;
								y_core = y + i;
								z_core = z + zi;
								pass = true;
								if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
									PalamodMod.LOGGER.info(("Core :  x : " + x_core + " y : " + y_core + " z : " + z_core));
								}
							}
							if (pass) {
								break;
							}
						}
					}
				}
			}
		}
	}
}