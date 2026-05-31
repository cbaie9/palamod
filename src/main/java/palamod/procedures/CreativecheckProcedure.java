package palamod.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class CreativecheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean ouput = false;
		if (entity instanceof Player _plr0 && _plr0.gameMode() == GameType.CREATIVE) {
			ouput = false;
		} else {
			ouput = true;
		}
		return ouput;
	}
}