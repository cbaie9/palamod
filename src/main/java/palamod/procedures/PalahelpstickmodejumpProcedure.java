package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class PalahelpstickmodejumpProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_STICK.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(0).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModItems.JUMP_ORB.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(1).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_STICK.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(2).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModBlocks.SLIMEPAD.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(3).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModBlocks.SLIMEPAD.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(4).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModItems.JUMPSTICK.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(5).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(9).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(7).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(11).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(13).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(Items.NETHER_WART).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(10).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(PalamodModItems.JUMP_ORB.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(15).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if ((world.getBlockState(new BlockPos(0, 10, 0))).getBlock() == PalamodModBlocks.NBT_BLOCK.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble(("mode_stick_" + entity.getStringUUID()), 2);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}