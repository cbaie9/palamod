package palamod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MixedendiumarmorChestplateTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 900, 1, false, false));
	}
}
