package palamod.procedures;

import palamod.entity.GodvillagerEntity;

import net.minecraft.world.entity.Entity;

public class ReturnusedtradeclickerProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + (entity instanceof GodvillagerEntity _datEntL0 && _datEntL0.getEntityData().get(GodvillagerEntity.DATA_trade_used));
	}
}
