package palamod.procedures;

import palamod.init.PalamodModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class DevchecksnapProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (((entity.getStringUUID()).equals("55f44420-6f63-4090-a3e9-965011c93fb2") || (entity.getStringUUID()).equals("29638ada-be7a-43f1-ad50-efa9ef9dd88c") || (entity.getDisplayName().getString()).equals("Dev"))
				&& entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(PalamodModMobEffects.ANTIFAKE.get())) {
			return true;
		}
		return false;
	}
}
