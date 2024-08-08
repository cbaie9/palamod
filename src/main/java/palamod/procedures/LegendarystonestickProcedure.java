package palamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class LegendarystonestickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("cooldown") > 0 && !(itemstack.getOrCreateTag().getDouble("cooldown") < 0)) {
			itemstack.getOrCreateTag().putDouble("cooldown", (itemstack.getOrCreateTag().getDouble("cooldown") - 1));
		}
		if (!("").equals(((itemstack.getOrCreateTag().getString("name")).replace("]", "")).replace("[", "")) && itemstack.getOrCreateTag().getDouble("cooldown") == 0) {
			itemstack.setHoverName(Component.literal((((itemstack.getOrCreateTag().getString("name")).replace("]", "")).replace("[", ""))));
		}
		if (entity.isShiftKeyDown()) {
			if (!("").equals(Component.translatable("palamod.procedure.legendarystonetick").getString() + "" + Math.round(itemstack.getOrCreateTag().getDouble("cooldown") / 20) + " s")) {
				itemstack.setHoverName(Component.literal((Component.translatable("palamod.procedure.legendarystonetick").getString() + "" + Math.round(itemstack.getOrCreateTag().getDouble("cooldown") / 20) + " s")));
			}
		} else {
			if (!("").equals(((itemstack.getOrCreateTag().getString("name")).replace("]", "")).replace("[", ""))) {
				itemstack.setHoverName(Component.literal((((itemstack.getOrCreateTag().getString("name")).replace("]", "")).replace("[", ""))));
			}
		}
	}
}
