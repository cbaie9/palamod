package palamod.procedures;

import palamod.init.PalamodModParticleTypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

public class Spacefood_processProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double yval = 0;
		yval = y;
		for (int index0 = 0; index0 < 900; index0++) {
			world.setBlock(BlockPos.containing(x, yval + 1, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, yval + 2, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, yval, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (PalamodModParticleTypes.FLYPARTICLE.get()), x, y, z, 2, 3, 3, 3, 1);
			{
				Entity _ent = entity;
				_ent.teleportTo(x, yval, z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, yval, z, _ent.getYRot(), _ent.getXRot());
			}
			yval = yval + 1;
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 900, 1, false, false));
	}
}
