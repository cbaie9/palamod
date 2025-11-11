package palamod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class LegendarystonestickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) > 0 && !(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) < 0)) {
			{
				final String _tagName = "cooldown";
				final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) - 1);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (!("").equals(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("name", "")).replace("]", "")).replace("[", ""))
				&& itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) == 0) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("name", "")).replace("]", "")).replace("[", ""))));
		}
		if (entity.isShiftKeyDown()) {
			if (!("").equals(Component.translatable("palamod.procedure.legendarystonetick").getString() + "" + Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) / 20) + " s")) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component
						.literal((Component.translatable("palamod.procedure.legendarystonetick").getString() + "" + Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) / 20) + " s")));
			}
		} else {
			if (!("").equals(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("name", "")).replace("]", "")).replace("[", ""))) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("name", "")).replace("]", "")).replace("[", ""))));
			}
		}
	}
}