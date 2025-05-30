package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class JobsminercraftmagicialtoolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "A tool that can";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text2 = "remove renforeced blocks";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text3 = "( only in your claims ";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text4 = "/ wilderness )";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text5 = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_durability = "Durability : Unbreakable";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.lvl_required = "Lvl required : 15";
			_vars.syncPlayerVariables(entity);
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) : false) && getAmountInGUISlot(entity, 1) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack.setCount(1);
				((Slot) _slots.get(1)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) : false) && getAmountInGUISlot(entity, 3) == 0) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(3)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PalamodModItems.PALADIUM_INGOT.get())) : false) && getAmountInGUISlot(entity, 5) == 0) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_INGOT.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(5)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get())) : false) && getAmountInGUISlot(entity, 4) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()).copy();
				_setstack.setCount(1);
				((Slot) _slots.get(4)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PalamodModItems.PALADIUM_STICK.get())) : false) && getAmountInGUISlot(entity, 7) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.PALADIUM_STICK.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_STICK.get()).copy();
				_setstack.setCount(1);
				((Slot) _slots.get(7)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof Supplier slotSupplier && slotSupplier.get() instanceof Map guiSlots) {
			ItemStack stack = ((Slot) guiSlots.get(sltid)).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}
