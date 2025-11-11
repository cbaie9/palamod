package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class OpengodvillagerguiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		PalamodMod.LOGGER.info("open_gui");
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack1 = new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()).copy();
			_setstack1.setCount(64);
			_menu.getSlots().get(2).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(3).set(_setstack2);
			_player.containerMenu.broadcastChanges();
		}
	}
}