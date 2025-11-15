package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class Adminshopcol5adminshopgetspriteProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return ((entity instanceof Player _entity0 && _entity0.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(2, "slider", 0.0) : 0.0) + 4;
	}
}