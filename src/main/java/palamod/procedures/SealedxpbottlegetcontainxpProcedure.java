package palamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class SealedxpbottlegetcontainxpProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((Component.translatable("palamod.procedure.sealed_xp_bottle_get_amount").getString() + " " + Math.round(itemstack.getOrCreateTag().getDouble("levels_stock")) + " "
					+ Component.translatable("palamod.procedure.sealed_xp_bottle_get_amount2").getString())), true);
	}
}
