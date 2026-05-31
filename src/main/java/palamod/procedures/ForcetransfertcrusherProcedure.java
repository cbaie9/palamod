package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.Container;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class ForcetransfertcrusherProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "crusher_lock") && (getBlockNBTString(world, BlockPos.containing(x, y, z), "crusher_mode")).equals("endium")) {
			if (Math.random() < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num") / 128) {
				if (world instanceof ServerLevel _serverLevel) {
					BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
					if (_be instanceof Container _container) {
						ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
						_setstack.setCount(1);
						_container.setItem(2, _setstack);
					}
				}
			}
		} else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "crusher_lock") && (getBlockNBTString(world, BlockPos.containing(x, y, z), "crusher_mode")).equals("paladium")) {
			if (Math.random() < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num") / 64) {
				if (world instanceof ServerLevel _serverLevel) {
					BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
					if (_be instanceof Container _container) {
						ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
						_setstack.setCount(10);
						_container.setItem(2, _setstack);
					}
				}
			}
		} else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "crusher_lock") && (getBlockNBTString(world, BlockPos.containing(x, y, z), "crusher_mode")).equals("titane")) {
			if (Math.random() < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num") / 32) {
				if (world instanceof ServerLevel _serverLevel) {
					BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
					if (_be instanceof Container _container) {
						ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
						_setstack.setCount(10);
						_container.setItem(2, _setstack);
					}
				}
			}
		} else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "crusher_lock") && (getBlockNBTString(world, BlockPos.containing(x, y, z), "crusher_mode")).equals("amethyste")) {
			if (Math.random() < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num") / 16) {
				if (world instanceof ServerLevel _serverLevel) {
					BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
					if (_be instanceof Container _container) {
						ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_INGOT.get()).copy();
						_setstack.setCount(20);
						_container.setItem(2, _setstack);
					}
				}
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putString("crusher_mode", "None");
				_blockEntity.getPersistentData().putBoolean("crusher_lock", true);
				_blockEntity.getPersistentData().putDouble("crusher_num", 0);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}