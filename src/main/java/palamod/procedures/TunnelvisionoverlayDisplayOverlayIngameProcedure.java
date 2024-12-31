package palamod.procedures;

import palamod.init.PalamodModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class TunnelvisionoverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean output = false;
		if (0 < (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PalamodModMobEffects.TUNNELVISION.get()) ? _livEnt.getEffect(PalamodModMobEffects.TUNNELVISION.get()).getAmplifier() : 0)) {
			output = true;
		} else {
			output = false;
		}
		return output;
	}
}
