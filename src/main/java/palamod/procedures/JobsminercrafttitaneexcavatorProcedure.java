package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsminercrafttitaneexcavatorProcedure {
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
			_vars.jobs_durability = "Durability : 2999";
			_vars.lvl_required = "Lvl required : 45";
			_vars.markSyncDirty();
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.TITANE_SHOVEL.get())) && getAmountInGUISlot(entity, 0) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.TITANE_SHOVEL.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack3 = new ItemStack(PalamodModItems.TITANE_SHOVEL.get()).copy();
				_setstack3.setCount(1);
				_menu.getSlots().get(0).set(_setstack3);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.TITANE_SHOVEL.get())) && getAmountInGUISlot(entity, 1) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.TITANE_SHOVEL.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack7 = new ItemStack(PalamodModItems.TITANE_SHOVEL.get()).copy();
				_setstack7.setCount(1);
				_menu.getSlots().get(1).set(_setstack7);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.TITANE_SHOVEL.get())) && getAmountInGUISlot(entity, 2) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.TITANE_SHOVEL.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack11 = new ItemStack(PalamodModItems.TITANE_SHOVEL.get()).copy();
				_setstack11.setCount(1);
				_menu.getSlots().get(2).set(_setstack11);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(Items.STICK)) && getAmountInGUISlot(entity, 4) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.STICK);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack15 = new ItemStack(Items.STICK).copy();
				_setstack15.setCount(1);
				_menu.getSlots().get(4).set(_setstack15);
				_player.containerMenu.broadcastChanges();
			}
			if (hasEntityInInventory(entity, new ItemStack(Items.STICK)) && getAmountInGUISlot(entity, 7) == 0) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Items.STICK);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack19 = new ItemStack(Items.STICK).copy();
					_setstack19.setCount(1);
					_menu.getSlots().get(7).set(_setstack19);
					_player.containerMenu.broadcastChanges();
				}
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