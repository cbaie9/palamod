package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class CraftdoneminerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(0).remove(1);
			_menu.getSlots().get(1).remove(1);
			_menu.getSlots().get(2).remove(1);
			_menu.getSlots().get(3).remove(1);
			_menu.getSlots().get(4).remove(1);
			_menu.getSlots().get(5).remove(1);
			_menu.getSlots().get(6).remove(1);
			_menu.getSlots().get(7).remove(1);
			_menu.getSlots().get(8).remove(1);
			_player.containerMenu.broadcastChanges();
		}
		GuijobsminercheckcraftProcedure.execute(world, x, y, z, entity);
	}
}