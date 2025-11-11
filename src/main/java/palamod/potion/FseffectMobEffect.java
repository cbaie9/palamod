package palamod.potion;

import palamod.procedures.FseffectEffectStartedappliedProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.server.level.ServerLevel;

public class FseffectMobEffect extends InstantenousMobEffect {
	public FseffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public void applyInstantenousEffect(ServerLevel level, Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		FseffectEffectStartedappliedProcedure.execute(level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}