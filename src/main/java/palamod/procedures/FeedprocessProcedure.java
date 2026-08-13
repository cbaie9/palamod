package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

public class FeedprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.COMMANDFEEDNOPERMACCESS) || entity.hasPermissions(2)) {
			MsgtellrawautosendProcedure.execute(world, x, y, z, entity, Component.translatable("palamod.procedure.feed_message").getString());
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 900, 1, false, false));
		} else {
			MsgtellrawautosendProcedure.execute(world, x, y, z, entity, Component.translatable("palamod.procedure.noperm").getString());
		}
	}
}