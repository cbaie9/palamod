package palamod.procedures;

import palamod.init.PalamodModBlocks;

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
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean pass = false;
		double y_core = 0;
		double x_core = 0;
		double z_core = 0;
		double loop = 0;
		BlockState active = Blocks.AIR.defaultBlockState();
		BlockState angle_block = Blocks.AIR.defaultBlockState();
		BlockState shiny_wood = Blocks.AIR.defaultBlockState();
		ItemStack key = ItemStack.EMPTY;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.AMETHYST_PORTALBLOCK.get()) {
			shiny_wood = PalamodModBlocks.SHINY_JACARANDA_WOOD.get().defaultBlockState();
			angle_block = PalamodModBlocks.AMETHYST_BLOCK.get().defaultBlockState();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.TITANE_PORTAL_BLOCK.get()) {
			shiny_wood = PalamodModBlocks.SHINY_JUDEECERCIS_WOOD.get().defaultBlockState();
			angle_block = PalamodModBlocks.TITANE_BLOCK.get().defaultBlockState();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.PALADIUM_PORTAL_BLOCK.get()) {
			shiny_wood = PalamodModBlocks.SHINY_ERABLE_WOOD.get().defaultBlockState();
			angle_block = PalamodModBlocks.PALADIUM_BLOCK.get().defaultBlockState();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.ENDIUM_PORTAL_BLOCK.get()) {
			shiny_wood = PalamodModBlocks.SHINY_OSTRYA_WOOD.get().defaultBlockState();
			angle_block = PalamodModBlocks.ENDIUM_PORTAL_ANGLE_BLOCK.get().defaultBlockState();
		}
		x_core = x;
		y_core = y;
		z_core = z;
		if (!CheckportalstructureProcedure.execute(world, z_core, y_core, x_core, angle_block, shiny_wood)) {
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