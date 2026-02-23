package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsminercraftpotgProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "The Unbreakable pickaxe !!";
			_vars.jobs_get_text2 = "Can be upgrade when mining";
			_vars.jobs_get_text3 = "a large amount of blocks";
			_vars.jobs_get_text4 = "";
			_vars.jobs_get_text5 = "";
			_vars.jobs_durability = "Durability : Unbreakable";
			_vars.lvl_required = "Lvl required : 1";
			_vars.markSyncDirty();
		}
		CraftdoneminerProcedure.execute(entity);
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(PalamodModItems.AMETHYST_PICKAXE.get()).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(0).set(_setstack0);
			ItemStack _setstack1 = new ItemStack(PalamodModItems.PALADIUM_PICKAXE.get()).copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(1).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(PalamodModItems.TITANE_PICKAXE.get()).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(2).set(_setstack2);
			ItemStack _setstack3 = new ItemStack(Items.STICK).copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(7).set(_setstack3);
			ItemStack _setstack4 = new ItemStack(Items.STICK).copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(4).set(_setstack4);
			ItemStack _setstack5 = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV1.get()).copy();
			_setstack5.setCount(1);
			_menu.getSlots().get(9).set(_setstack5);
			_player.containerMenu.broadcastChanges();
		}
	}
}