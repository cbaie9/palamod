package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class HanggliderItemInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean sneaking = false;
		double vert = 0;
		double horiz = 0;
		double x = 0;
		double z = 0;
		double yawRad = 0;
		if (entity instanceof Player && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("hang_state")) {
			if (entity.isShiftKeyDown()) {
				vert = 0.9;
				horiz = 0.2;
				sneaking = true;
			} else {
				vert = 0.925;
				horiz = 0.2;
			}
			if (!entity.onGround() && entity.getDeltaMovement().y() < 0) {
				yawRad = Math.toRadians(entity.getYRot() + 90.0D);
				x = Math.cos(yawRad) * horiz;
				z = Math.sin(yawRad) * horiz;
				entity.setDeltaMovement(new Vec3((x + entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() * vert), (z + entity.getDeltaMovement().z())));
				entity.fallDistance = 0;
			}
		}
	}
}