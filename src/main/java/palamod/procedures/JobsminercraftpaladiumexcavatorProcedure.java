package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsminercraftpaladiumexcavatorProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "A powerful shovel";
			_vars.jobs_get_text2 = "that can mine 3x3 blocks";
			_vars.jobs_get_text3 = "at once ( only work";
			_vars.jobs_get_text4 = "on blocks who can";
			_vars.jobs_get_text5 = "be broken by shovel )";
			_vars.jobs_durability = "Durability : 4999";
			_vars.lvl_required = "Lvl required : 67";
			_vars.markSyncDirty();
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) && (getAmountInGUISlot(entity, 0) == 0 || getAmountInGUISlot(entity, 0) < 64
				&& PalamodModItems.PALADIUM_INGOT.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack6 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack6.setCount(1);
				_menu.getSlots().get(0).set(_setstack6);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.TITANEEXCAVATOR.get())) && getAmountInGUISlot(entity, 1) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.TITANEEXCAVATOR.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack10 = new ItemStack(PalamodModItems.TITANEEXCAVATOR.get()).copy();
				_setstack10.setCount(1);
				_menu.getSlots().get(1).set(_setstack10);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.TITANEEXCAVATOR.get())) && getAmountInGUISlot(entity, 3) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.TITANEEXCAVATOR.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack14 = new ItemStack(PalamodModItems.TITANEEXCAVATOR.get()).copy();
				_setstack14.setCount(1);
				_menu.getSlots().get(3).set(_setstack14);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.TITANEEXCAVATOR.get())) && getAmountInGUISlot(entity, 5) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.TITANEEXCAVATOR.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack18 = new ItemStack(PalamodModItems.TITANEEXCAVATOR.get()).copy();
				_setstack18.setCount(1);
				_menu.getSlots().get(5).set(_setstack18);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.TITANEEXCAVATOR.get())) && getAmountInGUISlot(entity, 7) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.TITANEEXCAVATOR.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack22 = new ItemStack(PalamodModItems.TITANEEXCAVATOR.get()).copy();
				_setstack22.setCount(1);
				_menu.getSlots().get(7).set(_setstack22);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) && (getAmountInGUISlot(entity, 2) == 0 || getAmountInGUISlot(entity, 2) < 64
				&& PalamodModItems.PALADIUM_INGOT.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack29 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack29.setCount(1);
				_menu.getSlots().get(2).set(_setstack29);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) && (getAmountInGUISlot(entity, 6) == 0 || getAmountInGUISlot(entity, 6) < 64
				&& PalamodModItems.PALADIUM_INGOT.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack36 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack36.setCount(1);
				_menu.getSlots().get(6).set(_setstack36);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) && (getAmountInGUISlot(entity, 8) == 0 || getAmountInGUISlot(entity, 8) < 64
				&& PalamodModItems.PALADIUM_INGOT.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack43 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack43.setCount(1);
				_menu.getSlots().get(8).set(_setstack43);
				_player.containerMenu.broadcastChanges();
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
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