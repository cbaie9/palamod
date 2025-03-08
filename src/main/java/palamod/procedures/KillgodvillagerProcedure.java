package palamod.procedures;

import palamod.entity.GodvillagerEntity;

import palamod.PalamodMod;

import net.minecraft.world.entity.Entity;

public class KillgodvillagerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		PalamodMod.LOGGER.info("kill villager");
		if (entity instanceof GodvillagerEntity _datEntL1 && _datEntL1.getEntityData().get(GodvillagerEntity.DATA_trade_used)) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
