package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class GetupgradeinspawncontrollerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double iloop = 0;
		double slime = 0;
		double speed = 0;
		double more_upgrade = 0;
		double looting = 0;
		for (int index226 = 0; index226 < getBlockInventorySlotCount(world, BlockPos.containing(x, y, z)); index226++) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) iloop).copy()).getItem() == PalamodModItems.SPAWNER_UPGRADE_SLIME.get()) {
				slime = slime + 1;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) iloop).copy()).getItem() == PalamodModItems.SPAWNER_UPGRADE_SPEED.get()) {
				speed = speed + 1;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) iloop).copy()).getItem() == PalamodModItems.SPAWNER_UPGRADE_MORE.get()) {
				more_upgrade = more_upgrade + 1;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) iloop).copy()).getItem() == PalamodModItems.SPAWNER_UPGRADE_LOOTING.get()) {
				looting = looting + 1;
			}
			iloop = iloop + 1;
			if (iloop == 1 && more_upgrade < 1) {
				break;
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("nb_speed_upgrades", speed);
				_blockEntity.getPersistentData().putDouble("nb_slime_upgrades", slime);
				_blockEntity.getPersistentData().putDouble("nb_looting_upgrades", looting);
				_blockEntity.getPersistentData().putDouble("nb_more_upgrades", more_upgrade);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}

	private static int getBlockInventorySlotCount(LevelAccessor world, BlockPos pos) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getSlots();
		}
		return 0;
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