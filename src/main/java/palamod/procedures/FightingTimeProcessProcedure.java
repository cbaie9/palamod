package palamod.procedures;

import palamod.init.PalamodModAttributes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class FightingTimeProcessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		MsgtellrawautosendProcedure.execute(world, x, y, z, entity, ((Component.translatable("palamod.procedure.infight.getime").getString()).replace("%2",
				"" + ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME) ? _livingEntity1.getAttribute(PalamodModAttributes.FIGHTING_TIME).getBaseValue() : 0) / 20)))
				.replace("%1",
						"" + (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME) ? _livingEntity2.getAttribute(PalamodModAttributes.FIGHTING_TIME).getBaseValue() : 0)));
	}
}