package palamod.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class TunnelvisioneffectprocessProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plr0 && _plr0.gameMode() == GameType.CREATIVE)) {
			entity.getPersistentData().putBoolean("tunnel_vision", true);
		} else {
			entity.getPersistentData().putBoolean("tunnel_vision", false);
		}
	}
}