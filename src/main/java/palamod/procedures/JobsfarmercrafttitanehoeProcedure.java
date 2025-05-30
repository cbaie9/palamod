package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class JobsfarmercrafttitanehoeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "This hoe spade";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text2 = "in 4x4 area";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text3 = "in a single click";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text4 = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text5 = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_durability = "Durability : 4000";
			_vars.syncPlayerVariables(entity);
		}
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.lvl_required = "Lvl required : 20";
			_vars.syncPlayerVariables(entity);
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PalamodModItems.TITANE_INGOT.get())) : false) && (getAmountInGUISlot(entity, 1) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT.get()
						&& getAmountInGUISlot(entity, 1) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.TITANE_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
				_setstack.setCount((int) (getAmountInGUISlot(entity, 1) + 1));
				((Slot) _slots.get(1)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PalamodModItems.TITANE_INGOT.get())) : false) && (getAmountInGUISlot(entity, 0) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT.get()
						&& getAmountInGUISlot(entity, 0) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PalamodModItems.TITANE_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
				_setstack.setCount((int) (getAmountInGUISlot(entity, 0) + 1));
				((Slot) _slots.get(0)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.STICK)) : false) && (getAmountInGUISlot(entity, 4) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
						&& getAmountInGUISlot(entity, 4) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.STICK);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.STICK).copy();
				_setstack.setCount((int) (getAmountInGUISlot(entity, 4) + 1));
				((Slot) _slots.get(4)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.STICK)) : false) && (getAmountInGUISlot(entity, 7) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(7)).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
						&& getAmountInGUISlot(entity, 7) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.STICK);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.STICK).copy();
				_setstack.setCount((int) (getAmountInGUISlot(entity, 7) + 1));
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
