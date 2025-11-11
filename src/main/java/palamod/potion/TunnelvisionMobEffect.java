package palamod.potion;

import palamod.procedures.TunnelvisioneffectprocessProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerLevel;

public class TunnelvisionMobEffect extends MobEffect {
	public TunnelvisionMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		TunnelvisioneffectprocessProcedure.execute(entity);
		return super.applyEffectTick(level, entity, amplifier);
	}
}