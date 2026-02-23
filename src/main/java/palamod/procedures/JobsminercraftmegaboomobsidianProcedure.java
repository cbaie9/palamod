package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class JobsminercraftmegaboomobsidianProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PalamodModVariables.PlayerVariables _vars = entity.getData(PalamodModVariables.PLAYER_VARIABLES);
			_vars.jobs_get_text = "A obsidian when";
			_vars.jobs_get_text2 = "broke make a";
			_vars.jobs_get_text3 = "big explosion";
			_vars.jobs_get_text4 = "";
			_vars.jobs_get_text5 = "";
			_vars.jobs_durability = "No durability";
			_vars.lvl_required = "Lvl required : 23";
			_vars.markSyncDirty();
		}
		CraftdoneminerProcedure.execute(entity);
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(Items.GUNPOWDER).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(1).set(_setstack0);
			ItemStack _setstack1 = new ItemStack(Blocks.TNT).copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(7).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(Blocks.TNT).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(3).set(_setstack2);
			ItemStack _setstack3 = new ItemStack(Blocks.OBSIDIAN).copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(4).set(_setstack3);
			ItemStack _setstack4 = new ItemStack(Blocks.TNT).copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(5).set(_setstack4);
			_player.containerMenu.broadcastChanges();
		}
	}
}