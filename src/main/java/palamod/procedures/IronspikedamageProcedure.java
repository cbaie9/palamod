package palamod.procedures;

import palamod.network.PalamodModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class IronspikedamageProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (PalamodModVariables.cooltick_spike == 0) {
			{
				Entity _ent = entity;
				if (_ent.level() instanceof ServerLevel _serverLevel) {
					_ent.hurtServer(_serverLevel, new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.parse("palamod:spikedamage")))), (float) 4.5);
				}
			}
			PalamodModVariables.cooltick_spike = 60;
		} else {
			PalamodModVariables.cooltick_spike = PalamodModVariables.cooltick_spike - 1;
		}
	}
}