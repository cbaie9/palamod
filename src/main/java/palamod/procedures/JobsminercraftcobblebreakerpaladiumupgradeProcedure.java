package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsminercraftcobblebreakerpaladiumupgradeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "A upgrade";
			_vars.jobs_get_text2 = " that boost ";
			_vars.jobs_get_text3 = "the cobblebreaker ";
			_vars.jobs_get_text4 = "up to 4.0x speed";
			_vars.jobs_get_text5 = "";
			_vars.jobs_durability = "No durability";
			_vars.lvl_required = "Lvl required : 70";
			_vars.markSyncDirty();
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) && (getAmountInGUISlot(entity, 0) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
						&& getAmountInGUISlot(entity, 0) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack7 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack7.setCount(getAmountInGUISlot(entity, 0) + 1);
				_menu.getSlots().get(0).set(_setstack7);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) && (getAmountInGUISlot(entity, 2) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
						&& getAmountInGUISlot(entity, 2) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack15 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack15.setCount(getAmountInGUISlot(entity, 2) + 1);
				_menu.getSlots().get(2).set(_setstack15);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) && (getAmountInGUISlot(entity, 6) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
						&& getAmountInGUISlot(entity, 6) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack23 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack23.setCount(getAmountInGUISlot(entity, 6) + 1);
				_menu.getSlots().get(6).set(_setstack23);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) && (getAmountInGUISlot(entity, 8) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
						&& getAmountInGUISlot(entity, 8) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack31 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack31.setCount(getAmountInGUISlot(entity, 8) + 1);
				_menu.getSlots().get(8).set(_setstack31);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_INGOT.get()))
				&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
						&& getAmountInGUISlot(entity, 3) < 64 || getAmountInGUISlot(entity, 3) == 0)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack39 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack39.setCount(getAmountInGUISlot(entity, 3) + 1);
				_menu.getSlots().get(3).set(_setstack39);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get()))
				&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get(4).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get() && getAmountInGUISlot(entity, 4) < 64 || getAmountInGUISlot(entity, 4) == 0)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack47 = new ItemStack(PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get()).copy();
				_setstack47.setCount(getAmountInGUISlot(entity, 4) + 1);
				_menu.getSlots().get(4).set(_setstack47);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.PALADIUM_INGOT.get()))
				&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
						&& getAmountInGUISlot(entity, 5) < 64 || getAmountInGUISlot(entity, 5) == 0)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack55 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack55.setCount(getAmountInGUISlot(entity, 5) + 1);
				_menu.getSlots().get(5).set(_setstack55);
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