package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsfarmerpaladiumhoeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "This hoe spade";
			_vars.jobs_get_text2 = "in 6x6 area";
			_vars.jobs_get_text3 = "in a single click";
			_vars.jobs_get_text4 = "";
			_vars.jobs_get_text5 = "";
			_vars.jobs_durability = "Durability : 5000";
			_vars.lvl_required = "Lvl required : 12";
			_vars.markSyncDirty();
		}
		CraftdoneminerProcedure.execute(entity);
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(1).set(_setstack0);
			ItemStack _setstack1 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(0).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(Items.STICK).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(4).set(_setstack2);
			ItemStack _setstack3 = new ItemStack(Items.STICK).copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(7).set(_setstack3);
			ItemStack _setstack4 = new ItemStack(PalamodModItems.PALADIUM_HOE.get()).copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(9).set(_setstack4);
			_player.containerMenu.broadcastChanges();
		}
	}
}