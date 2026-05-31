package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class FaccreateguicheckpalaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& parseDouble(PalamodModVariables.faction_create_ing) > 0) {
			PalamodModVariables.faction_create_ing = "remaining to insert :" + (parseDouble(PalamodModVariables.faction_create_ing) + 1);
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if ((PalamodModVariables.faction_create_ing).equals("remaining to insert :100")) {
				PalamodModVariables.faction_create_ing = "You can now create the faction";
			}
		}
	}

	private static double parseDouble(String s) {
		try {
			return Double.parseDouble(s.trim());
		} catch (Exception e) {
			return 0;
		}
	}
}