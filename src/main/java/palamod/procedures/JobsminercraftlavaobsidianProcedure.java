package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsminercraftlavaobsidianProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "A obsidian that pose";
			_vars.jobs_get_text2 = "lava when broken";
			_vars.jobs_get_text3 = "";
			_vars.jobs_get_text4 = "";
			_vars.jobs_get_text5 = "";
			_vars.jobs_durability = "No durability";
			_vars.lvl_required = "Lvl required : 39";
			_vars.markSyncDirty();
		}
		if (hasEntityInInventory(entity, new ItemStack(Items.LAVA_BUCKET)) && getAmountInGUISlot(entity, 0) == 0) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Items.LAVA_BUCKET);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack3 = new ItemStack(Items.LAVA_BUCKET).copy();
				_setstack3.setCount(1);
				_menu.getSlots().get(0).set(_setstack3);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(Blocks.OBSIDIAN)) && (getAmountInGUISlot(entity, 0) == 0
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
						&& getAmountInGUISlot(entity, 1) < 64)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Blocks.OBSIDIAN);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack11 = new ItemStack(Blocks.OBSIDIAN).copy();
				_setstack11.setCount(getAmountInGUISlot(entity, 1) + 1);
				_menu.getSlots().get(0).set(_setstack11);
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