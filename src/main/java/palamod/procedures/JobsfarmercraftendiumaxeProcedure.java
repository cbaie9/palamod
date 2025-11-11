package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsfarmercraftendiumaxeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "Ultimate axe";
			_vars.jobs_get_text2 = "";
			_vars.jobs_get_text3 = "";
			_vars.jobs_get_text4 = "";
			_vars.jobs_get_text5 = "";
			_vars.jobs_durability = "No durability";
			_vars.lvl_required = "Lvl required : 100";
			_vars.markSyncDirty();
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.ENDIUM_INGOT.get())) && (getAmountInGUISlot(entity, 0) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT.get()
						&& getAmountInGUISlot(entity, 0) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.ENDIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack7 = new ItemStack(PalamodModItems.ENDIUM_INGOT.get()).copy();
				_setstack7.setCount(getAmountInGUISlot(entity, 0) + 1);
				_menu.getSlots().get(0).set(_setstack7);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.ENDIUM_INGOT.get())) && (getAmountInGUISlot(entity, 1) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT.get()
						&& getAmountInGUISlot(entity, 1) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.ENDIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack15 = new ItemStack(PalamodModItems.ENDIUM_INGOT.get()).copy();
				_setstack15.setCount(getAmountInGUISlot(entity, 1) + 1);
				_menu.getSlots().get(1).set(_setstack15);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.ENDIUM_INGOT.get())) && (getAmountInGUISlot(entity, 3) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT.get()
						&& getAmountInGUISlot(entity, 3) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.ENDIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack23 = new ItemStack(PalamodModItems.ENDIUM_INGOT.get()).copy();
				_setstack23.setCount(getAmountInGUISlot(entity, 3) + 1);
				_menu.getSlots().get(3).set(_setstack23);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(Items.STICK)) && (getAmountInGUISlot(entity, 4) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
						&& getAmountInGUISlot(entity, 4) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.STICK);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack31 = new ItemStack(Items.STICK).copy();
				_setstack31.setCount(getAmountInGUISlot(entity, 4) + 1);
				_menu.getSlots().get(4).set(_setstack31);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(Items.STICK)) && (getAmountInGUISlot(entity, 7) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
						&& getAmountInGUISlot(entity, 7) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.STICK);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack39 = new ItemStack(Items.STICK).copy();
				_setstack39.setCount(getAmountInGUISlot(entity, 7) + 1);
				_menu.getSlots().get(7).set(_setstack39);
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