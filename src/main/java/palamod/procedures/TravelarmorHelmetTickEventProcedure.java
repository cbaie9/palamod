package palamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

public class TravelarmorHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.AIR) || !((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.VOID_AIR)
				|| !((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.CAVE_AIR)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 1, true, false));
		}
	}
}
