package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class Crusherv2endiumProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num_endium") >= 128) {
			if (PalamodModItems.ENDIUM_NUGGET.get() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() && 63 >= itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount()
					|| 0 == itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount()) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
					_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1));
					_itemHandlerModifiable.setStackInSlot(2, _setstack);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("crusher_num_endium", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((("X : " + x + "Y : " + y + "Z : " + z) + "use the Palamachine ( endium )"));
				}
			}
		} else {
			if (Math.random() < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num_endium") / 128) {
				if (PalamodModItems.ENDIUM_NUGGET.get() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() && 63 >= itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount()
						|| 0 == itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount()) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
						_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1));
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("crusher_num_endium", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
						PalamodMod.LOGGER.info((("X : " + x + "Y : " + y + "Z : " + z) + "use the Palamachine ( random ) ( sucess ) ( endium )"));
					}
				}
			} else {
				if (Blocks.DIRT.asItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() && 63 >= itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount()
						|| 0 == itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount()) {
					if (1 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "crusher_num_endium")) {
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = new ItemStack(Blocks.DIRT).copy();
							_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1));
							_itemHandlerModifiable.setStackInSlot(2, _setstack);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("crusher_num_endium", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
							PalamodMod.LOGGER.info((("X : " + x + "Y : " + y + "Z : " + z) + "use the Palamachine ( random ) ( failed ) ( endium ) "));
						}
					}
				}
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}
