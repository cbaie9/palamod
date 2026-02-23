package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsminercraftcompactobsidianProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "A obsidian that";
			_vars.jobs_get_text2 = "replace itself";
			_vars.jobs_get_text3 = "when broke";
			_vars.jobs_get_text4 = "";
			_vars.jobs_get_text5 = "";
			_vars.jobs_durability = "No durability";
			_vars.lvl_required = "Lvl required : NR";
			_vars.markSyncDirty();
		}
		CraftdoneminerProcedure.execute(entity);
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(Blocks.OBSIDIAN).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(0).set(_setstack0);
			ItemStack _setstack1 = new ItemStack(Blocks.OBSIDIAN).copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(1).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(Blocks.OBSIDIAN).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(2).set(_setstack2);
			ItemStack _setstack3 = new ItemStack(Blocks.OBSIDIAN).copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(3).set(_setstack3);
			ItemStack _setstack4 = new ItemStack(PalamodModItems.PALADIUM_CORE.get()).copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(4).set(_setstack4);
			ItemStack _setstack5 = new ItemStack(Blocks.OBSIDIAN).copy();
			_setstack5.setCount(1);
			_menu.getSlots().get(5).set(_setstack5);
			ItemStack _setstack6 = new ItemStack(Blocks.OBSIDIAN).copy();
			_setstack6.setCount(1);
			_menu.getSlots().get(7).set(_setstack6);
			ItemStack _setstack7 = new ItemStack(Blocks.OBSIDIAN).copy();
			_setstack7.setCount(1);
			_menu.getSlots().get(6).set(_setstack7);
			ItemStack _setstack8 = new ItemStack(Blocks.OBSIDIAN).copy();
			_setstack8.setCount(1);
			_menu.getSlots().get(8).set(_setstack8);
			ItemStack _setstack9 = new ItemStack(PalamodModBlocks.COMPACTED_OBSIDIAN.get()).copy();
			_setstack9.setCount(1);
			_menu.getSlots().get(9).set(_setstack9);
			_player.containerMenu.broadcastChanges();
		}
	}
}