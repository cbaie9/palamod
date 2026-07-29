package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class FillSlotPalahelpXpGainProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double i = 0;
		ItemStack output = ItemStack.EMPTY;
		output = GetItemPalahelpJobsXpgainProcedure.execute(entity, true, 0).copy();
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = output.copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(0).set(_setstack0);
			_player.containerMenu.broadcastChanges();
		}
		output = GetItemPalahelpJobsXpgainProcedure.execute(entity, true, 1).copy();
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack1 = output.copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(1).set(_setstack1);
			_player.containerMenu.broadcastChanges();
		}
		output = GetItemPalahelpJobsXpgainProcedure.execute(entity, true, 2).copy();
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack2 = output.copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(2).set(_setstack2);
			_player.containerMenu.broadcastChanges();
		}
		output = GetItemPalahelpJobsXpgainProcedure.execute(entity, true, 3).copy();
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack3 = output.copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(3).set(_setstack3);
			_player.containerMenu.broadcastChanges();
		}
		output = GetItemPalahelpJobsXpgainProcedure.execute(entity, true, 4).copy();
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack4 = output.copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(4).set(_setstack4);
			_player.containerMenu.broadcastChanges();
		}
		output = GetItemPalahelpJobsXpgainProcedure.execute(entity, true, 5).copy();
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack5 = output.copy();
			_setstack5.setCount(1);
			_menu.getSlots().get(5).set(_setstack5);
			_player.containerMenu.broadcastChanges();
		}
	}
}