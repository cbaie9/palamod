
package palamod.potion;

import palamod.procedures.AntifakeOnEffect_delete_nbtProcedure;
import palamod.procedures.AntifakeEffect_add_nbtProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AntifakeMobEffect extends MobEffect {
	public AntifakeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13434676);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		AntifakeEffect_add_nbtProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		AntifakeOnEffect_delete_nbtProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
