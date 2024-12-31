package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class TunnelvisionEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("tunnel_vision", false);
	}
}
