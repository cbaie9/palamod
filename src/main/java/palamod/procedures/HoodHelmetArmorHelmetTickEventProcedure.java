package palamod.procedures;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HoodHelmetArmorHelmetTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(NeoForgeMod.NAMETAG_DISTANCE))
			_livingEntity0.getAttribute(NeoForgeMod.NAMETAG_DISTANCE).setBaseValue(0);
	}
}