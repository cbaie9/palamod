package palamod.procedures;

import palamod.world.inventory.BackpacktitaneMenu;
import palamod.world.inventory.BackpackpaladiumMenu;
import palamod.world.inventory.BackpackendiumMenu;
import palamod.world.inventory.BackpackamethystguiMenu;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class GetslotbackpackProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double i2 = 0;
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof BackpackamethystguiMenu) {
			i2 = 9;
		} else if (entity instanceof Player _plr1 && _plr1.containerMenu instanceof BackpacktitaneMenu) {
			i2 = 27;
		} else if (entity instanceof Player _plr2 && _plr2.containerMenu instanceof BackpackpaladiumMenu) {
			i2 = 55;
		} else if (entity instanceof Player _plr3 && _plr3.containerMenu instanceof BackpackendiumMenu) {
			i2 = 82;
		} else {
			i2 = 0;
		}
		return i2;
	}
}
