package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsminercraftcobblebreakertitaneupgradeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "A upgrade";
			_vars.jobs_get_text2 = " that boost ";
			_vars.jobs_get_text3 = "the cobblebreaker ";
			_vars.jobs_get_text4 = "up to 2.5x speed";
			_vars.jobs_get_text5 = "";
			_vars.jobs_durability = "No durability";
			_vars.lvl_required = "Lvl required : 13";
			_vars.markSyncDirty();
		}
		CraftdoneminerProcedure.execute(entity);
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(0).set(_setstack0);
			ItemStack _setstack1 = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(2).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(6).set(_setstack2);
			ItemStack _setstack3 = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(3).set(_setstack3);
			ItemStack _setstack4 = new ItemStack(PalamodModItems.COBBLEBREAKER_AMETHYST_UPGRADE.get()).copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(4).set(_setstack4);
			ItemStack _setstack5 = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
			_setstack5.setCount(1);
			_menu.getSlots().get(5).set(_setstack5);
			ItemStack _setstack6 = new ItemStack(PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get()).copy();
			_setstack6.setCount(1);
			_menu.getSlots().get(9).set(_setstack6);
			_player.containerMenu.broadcastChanges();
		}
	}
}