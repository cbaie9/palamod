package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class TrixiumdepositprocessProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TrixiumsetupProcedure.execute(world);
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.TRIXIUM_BLOCK.get().asItem()) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 11, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble(("trixium_score_" + entity.getDisplayName().getString()),
							(getBlockNBTNumber(world, new BlockPos(0, 11, 0), ("trixium_score_" + entity.getDisplayName().getString())) + getAmountInGUISlot(entity, 0) * 9));
					_blockEntity.getPersistentData().putDouble("trixium_totalscore", (getBlockNBTNumber(world, new BlockPos(0, 11, 0), "trixium_totalscore") + getAmountInGUISlot(entity, 0) * 9));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TRIXIUM.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 11, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("trixium_totalscore", (getBlockNBTNumber(world, new BlockPos(0, 11, 0), "trixium_totalscore") + getAmountInGUISlot(entity, 0)));
					_blockEntity.getPersistentData().putDouble(("trixium_score_" + entity.getDisplayName().getString()),
							(getBlockNBTNumber(world, new BlockPos(0, 11, 0), ("trixium_score_" + entity.getDisplayName().getString())) + getAmountInGUISlot(entity, 0)));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof PalamodModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}