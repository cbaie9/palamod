package palamod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MixedendiumarmorLeggingsTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 180, 2, false, false));
	}
}
