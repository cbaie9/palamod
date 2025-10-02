package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class FaccreateguistartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "faction_name_input_bow", (entity.getPersistentData().getString("temp_fact_name")), true);
		PalamodModVariables.faction_create_ing = "remaining to insert : 100";
	}
}