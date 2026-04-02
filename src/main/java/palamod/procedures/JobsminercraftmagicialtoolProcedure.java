package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsminercraftmagicialtoolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "A tool that can";
			_vars.jobs_get_text2 = "remove renforeced blocks";
			_vars.jobs_get_text3 = "( only in your claims ";
			_vars.jobs_get_text4 = "/ wilderness )";
			_vars.jobs_get_text5 = "";
			_vars.jobs_durability = "Durability : Unbreakable";
			_vars.lvl_required = "Lvl required : NR";
			_vars.markSyncDirty();
		}
		CraftdoneminerProcedure.execute(entity);
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(1).set(_setstack0);
			ItemStack _setstack1 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(3).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(5).set(_setstack2);
			ItemStack _setstack3 = new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()).copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(4).set(_setstack3);
			ItemStack _setstack4 = new ItemStack(PalamodModItems.PALADIUM_STICK.get()).copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(7).set(_setstack4);
			ItemStack _setstack5 = new ItemStack(PalamodModItems.MAGICAL_TOOL.get()).copy();
			_setstack5.setCount(1);
			_menu.getSlots().get(9).set(_setstack5);
			_player.containerMenu.broadcastChanges();
		}
	}
}