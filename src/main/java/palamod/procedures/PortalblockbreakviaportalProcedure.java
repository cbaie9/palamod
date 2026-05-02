package palamod.procedures;

import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
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
							loop = loop + 1;
						}
					}
				}
			}
		}
		if (pass && !CheckportalstructureProcedure.execute(world, z_core, y_core, x_core, angle_block, shiny_wood)) {
			if ((getBlockNBTString(world, BlockPos.containing(x_core, y_core, z_core), "position")).equals("west")) {
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 2, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 2, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 2, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core + 3, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 3, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core + 3, y_core, z_core - 1), false);
			} else if ((getBlockNBTString(world, BlockPos.containing(x_core, y_core, z_core), "position")).equals("east")) {
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 2, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 2, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 2, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core - 3, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 3, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core - 3, y_core, z_core - 1), false);
			} else if ((getBlockNBTString(world, BlockPos.containing(x_core, y_core, z_core), "position")).equals("north")) {
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core - 2), false);
				world.destroyBlock(BlockPos.containing(x_core, y_core, z_core - 2), false);
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core - 2), false);
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core - 3), false);
				world.destroyBlock(BlockPos.containing(x_core, y_core, z_core - 3), false);
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core - 3), false);
			} else if ((getBlockNBTString(world, BlockPos.containing(x_core, y_core, z_core), "position")).equals("south")) {
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core + 2), false);
				world.destroyBlock(BlockPos.containing(x_core, y_core, z_core + 2), false);
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core + 2), false);
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core + 3), false);
				world.destroyBlock(BlockPos.containing(x_core, y_core, z_core + 3), false);
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core + 3), false);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x_core, y_core, z_core);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("portal_powered", false);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x_core, (y_core + 0.25), z_core, (getBlockNBTItemStack(world, BlockPos.containing(x_core, y_core, z_core), "key")));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().put("key", new ItemStack(Blocks.AIR).saveOptional(world.registryAccess()));
					_blockEntity.getPersistentData().putString("position", "None");
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static ItemStack getBlockNBTItemStack(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return ItemStack.parseOptional(world.registryAccess(), blockEntity.getPersistentData().getCompound(tag));
		return ItemStack.EMPTY;
	}
}