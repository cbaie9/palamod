package palamod.procedures;

import palamod.init.PalamodModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class FightimeOverlayGetindexProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double maxfightingtime = 0;
		if (0 < entity.getPersistentData().getDoubleOr("MaxFightingTime", 0)) {
			maxfightingtime = entity.getPersistentData().getDoubleOr("MaxFightingTime", 0);
		} else {
			maxfightingtime = 400;
		}
		return Math.round(((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME) ? _livingEntity2.getAttribute(PalamodModAttributes.FIGHTING_TIME).getBaseValue() : 0)
				/ maxfightingtime) * 21);
	}
}