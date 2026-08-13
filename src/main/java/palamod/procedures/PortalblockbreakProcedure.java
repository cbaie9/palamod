package palamod.procedures;

import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class PortalblockbreakProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState called) {
		double y_core = 0;
		double x_core = 0;
		double z_core = 0;
		double loop = 0;
		BlockState active = Blocks.AIR.defaultBlockState();
		BlockState angle_block = Blocks.AIR.defaultBlockState();
		BlockState shiny_wood = Blocks.AIR.defaultBlockState();
		ItemStack key = ItemStack.EMPTY;
		boolean pass = false;
		boolean master_check = false;
		PalamodMod.LOGGER.debug("break portal via ");
		for (int index125 = 0; index125 < 4; index125++) {
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
			int horizontalRadiusSquare = (int) 8 - 1;
			int verticalRadiusSquare = (int) 3 - 1;
			int yIterationsSquare = verticalRadiusSquare;
			for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
				for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
					for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
						// Execute the desired statements within the square/cube
						if (active.getBlock() == (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock()) {
							x_core = x + xi;
							y_core = y + i;
							z_core = z + zi;
							pass = true;
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
								PalamodMod.LOGGER.info(("Core :  x : " + x_core + " y : " + y_core + " z : " + z_core + "\n" + "pass mode : " + active));
							}
						}
					}
				}
			}
			if (pass) {
				break;
			}
			loop = loop + 1;
		}
		master_check = !CheckportalstructureProcedure.execute(world, z_core, y_core, x_core, angle_block, shiny_wood);
		PalamodMod.LOGGER.info(("powered : " + getBlockNBTLogic(world, BlockPos.containing(x_core, y_core, z_core), "portal_powered") + "called via : " + called + "condit : " + (called.getBlock() == PalamodModBlocks.PORTAL_BLOCK.get()) + "\n"
				+ "mastercheck : " + master_check));
		PalamodMod.LOGGER.debug(("all :" + (pass && getBlockNBTLogic(world, BlockPos.containing(x_core, y_core, z_core), "portal_powered") && (master_check
				|| called.getBlock() == PalamodModBlocks.PORTAL_BLOCK.get() && IsPortalGlassActuallyBrokenProcedure.execute(world, x_core, y_core, z_core, getBlockNBTString(world, BlockPos.containing(x_core, y_core, z_core), "position"))))));
		if (pass && getBlockNBTLogic(world, BlockPos.containing(x_core, y_core, z_core), "portal_powered") && (master_check
				|| called.getBlock() == PalamodModBlocks.PORTAL_BLOCK.get() && IsPortalGlassActuallyBrokenProcedure.execute(world, x_core, y_core, z_core, getBlockNBTString(world, BlockPos.containing(x_core, y_core, z_core), "position")))) {
			if ((getBlockNBTString(world, BlockPos.containing(x_core, y_core, z_core), "position")).equals("west")) {
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core - 1, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 2, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 2, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 2, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core - 3, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core - 3, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core - 3, y_core, z_core - 1), false);
			} else if ((getBlockNBTString(world, BlockPos.containing(x_core, y_core, z_core), "position")).equals("east")) {
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core + 1, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 2, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 2, y_core, z_core - 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 2, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core + 3, y_core, z_core + 1), false);
				world.destroyBlock(BlockPos.containing(x_core + 3, y_core, z_core), false);
				world.destroyBlock(BlockPos.containing(x_core + 3, y_core, z_core - 1), false);
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
			world.destroyBlock(BlockPos.containing(x_core, y_core + 1, z_core), false);
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
			key = (getBlockNBTItemStack(world, BlockPos.containing(x_core, y_core, z_core), "key")).copy();
			{
				final String _tagName = "key_stock";
				final double _tagValue = (getBlockNBTNumber(world, BlockPos.containing(x_core, y_core, z_core), "key_stock"));
				CustomData.update(DataComponents.CUSTOM_DATA, key, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "key_type";
				final String _tagValue = (getBlockNBTString(world, BlockPos.containing(x_core, y_core, z_core), "key_type"));
				CustomData.update(DataComponents.CUSTOM_DATA, key, tag -> tag.putString(_tagName, _tagValue));
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x_core, (y_core + 0.25), z_core, key);
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

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
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

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}