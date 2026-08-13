package palamod.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class ToolresetcloseProcedure {
	public static void execute(LevelAccessor world) {
		double nloop = 0;
		nloop = 0;
		for (int index34 = 0; index34 < 100; index34++) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, new BlockPos(0, 10, 0), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
				_itemHandlerModifiable.setStackInSlot((int) nloop, ItemStack.EMPTY);
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean(("market_buyed" + nloop), true);
					_blockEntity.getPersistentData().putDouble(("market_num" + nloop), 0);
					_blockEntity.getPersistentData().putDouble(("market_price" + nloop), 0);
					_blockEntity.getPersistentData().putDouble(("market_hash" + nloop), 0);
					_blockEntity.getPersistentData().putString(("market_name" + nloop), "Ns_wrbt");
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			nloop = nloop + 1;
		}
	}
}