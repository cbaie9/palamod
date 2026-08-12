package palamod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class Paladiumpickaxehaste3Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (0 > entity.getY() && -64 < entity.getY()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 30, 4, false, false));
		}
	}
}