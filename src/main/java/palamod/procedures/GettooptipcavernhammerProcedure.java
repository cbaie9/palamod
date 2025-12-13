package palamod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class GettooptipcavernhammerProcedure {
	public static String execute(ItemStack itemstack) {
		String output = "";
		double tier = 0;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("soul") == 0) {
			output = Component.translatable("palamod.item.cavern_hammer_no_soul").getString();
		} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("soul") > 0 && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("soul") < 50) {
			output = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("soul") + " " + Component.translatable("palamod.item.cavern_hammer_souls").getString() + " "
					+ itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("spawner_type");
		} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("soul") > 50) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("palamod.item.custom_spawner_display").getString())));
			tier = Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("soul") / 50) > 4
					? 4
					: Math.floor(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("soul") / 50);
			output = Component.translatable("palamod.item.cavern_hammer_tier").getString() + " " + Math.round(tier) + " - " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("soul") + " "
					+ Component.translatable("palamod.item.cavern_hammer_souls").getString() + " " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("spawner_type");
		} else {
			output = " ";
		}
		return output;
	}
}