package palamod.procedures;

import palamod.init.PalamodModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class FightingTimeOverlayGetLabelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String output = "";
		output = "";
		if (0 < (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME) ? _livingEntity0.getAttribute(PalamodModAttributes.FIGHTING_TIME).getBaseValue() : 0)) {
			output = (Component.translatable("palamod.procedure.infight.overlayLabel").getString()).replace("%1",
					"" + ((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(PalamodModAttributes.FIGHTING_TIME) ? _livingEntity2.getAttribute(PalamodModAttributes.FIGHTING_TIME).getBaseValue() : 0) / 20));
		}
		return output;
	}
}