package palamod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class SealedxpbottlegetcontainxpProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player)
			_player.sendSystemMessage(
					Component.literal((Component.translatable("palamod.procedure.sealed_xp_bottle_get_amount").getString() + " "
							+ Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("levels_stock", 0)) + " " + Component.translatable("palamod.procedure.sealed_xp_bottle_get_amount2").getString())),
					true);
	}
}