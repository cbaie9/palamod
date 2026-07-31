package palamod.procedures;

import palamod.world.inventory.PalahelpJobsxpgainMenu;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class LoadAlchiCraftPalahelpJobsXpGainProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("jobs_mode", "alchi");
		entity.getPersistentData().putString("xp_mode", "craft");
		entity.getPersistentData().putDouble("indexSlider", 0);
		if (entity instanceof Player _plr3 && _plr3.containerMenu instanceof PalahelpJobsxpgainMenu) {
			FillSlotPalahelpXpGainProcedure.execute(entity);
		}
	}
}