package palamod.procedures;

import palamod.init.PalamodModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class Givepotionx2expProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(PalamodModMobEffects.MULTIEXP_2.get(), 36000, 1, false, false));
	}
}
