package palamod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class TooptipflaskrenderProcedure {
	public static String execute(ItemStack itemstack) {
		String wood = "";
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type") == 1) {
			wood = Component.translatable("palamod.tooltip.flask_ostrya").getString();
		} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type") == 2) {
			wood = Component.translatable("palamod.tooltip.flask_judeecercis").getString();
		} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type") == 3) {
			wood = Component.translatable("palamod.tooltip.flask_jacaranda").getString();
		} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type") == 4) {
			wood = Component.translatable("palamod.tooltip.flask_erable").getString();
		}
		return Component.translatable("palamod.tooltip.flask_amount").getString() + " : " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("seve") + " - "
				+ Component.translatable("palamod.tooltip.flask_type").getString() + " : " + wood;
	}
}