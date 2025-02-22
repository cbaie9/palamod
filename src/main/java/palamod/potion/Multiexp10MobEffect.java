
package palamod.potion;

import palamod.procedures.Addmultixp10fileProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class Multiexp10MobEffect extends MobEffect {
	public Multiexp10MobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10027264);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		Addmultixp10fileProcedure.execute(entity.level(), entity);
	}
}
