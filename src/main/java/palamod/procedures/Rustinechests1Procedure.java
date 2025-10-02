package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class Rustinechests1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean is12 = false;
		boolean is13 = false;
		boolean is110 = false;
		boolean is111 = false;
		boolean is12full = false;
		boolean is13full = false;
		boolean is110full = false;
		boolean is111full = false;
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "setlocal_chestver") == 1) {
			is12 = true;
			if (getAmountInGUISlot(entity, 0) > 0) {
				is12full = true;
			} else {
				is12full = false;
			}
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "setlocal_chestver") == 2) {
			is12 = true;
			is13 = true;
			if (getAmountInGUISlot(entity, 0) > 0) {
				is12full = true;
			} else {
				is12full = false;
			}
			if (getAmountInGUISlot(entity, 0) > 0) {
				is13full = true;
			} else {
				is13full = false;
			}
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "setlocal_chestver") == 3) {
			is12 = true;
			is13 = true;
			is110 = true;
			is111 = true;
			if (getAmountInGUISlot(entity, 12) > 0) {
				is12full = true;
			} else {
				is12full = true;
			}
			if (getAmountInGUISlot(entity, 13) > 0) {
				is13full = true;
			} else {
				is13full = false;
			}
			if (getAmountInGUISlot(entity, 110) > 0) {
				is110full = true;
			} else {
				is110full = false;
			}
			if (getAmountInGUISlot(entity, 111) > 0) {
				is111full = true;
			} else {
				is111full = false;
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(109).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("palamod:rings")))) {
			if (is12 && !is12full) {
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(109).getItem() : ItemStack.EMPTY).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(12).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(109).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			} else if (is13 && !is13full) {
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(109).getItem() : ItemStack.EMPTY).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(13).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(109).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			} else if (is110 && !is110full) {
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(109).getItem() : ItemStack.EMPTY).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(110).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(109).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			} else if (is111 && !is111full) {
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(109).getItem() : ItemStack.EMPTY).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(111).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(109).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
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

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof PalamodModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}