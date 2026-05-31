package palamod.procedures;

import palamod.init.PalamodModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class FightingTimeOverlayGetLogicProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return 1 == (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(PalamodModAttributes.IS_FIGHTING) ? _livingEntity0.getAttribute(PalamodModAttributes.IS_FIGHTING).getBaseValue() : 0);
	}
}