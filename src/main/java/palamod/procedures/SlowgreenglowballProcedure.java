package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class SlowgreenglowballProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (PalamodModVariables.cooltick_spike == 0) {
			PalamodModVariables.cooltick_spike = 20;
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1));
		} else {
			PalamodModVariables.cooltick_spike = PalamodModVariables.cooltick_spike - 1;
		}
	}
}
