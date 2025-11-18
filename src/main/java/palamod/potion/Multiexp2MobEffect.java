package palamod.potion;

import palamod.procedures.Addmultixp2fileProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class Multiexp2MobEffect extends MobEffect {
	public Multiexp2MobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10027264);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		Addmultixp2fileProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}