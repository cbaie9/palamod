package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class TooltiprenderingprocessProcedure {
	public static void execute(ItemStack itemstack) {
		String jobs = "";
		if (itemstack.getItem() == PalamodModItems.XP_BOTTLE.get()) {
			if (0 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type")) {
				jobs = "empty";
			} else if (1 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type")) {
				jobs = Component.translatable("palamod.procedure.jobs_miner").getString();
			} else if (2 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type")) {
				jobs = Component.translatable("palamod.procedure.jobs_farmer").getString();
			} else if (3 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type")) {
				jobs = Component.translatable("palamod.procedure.jobs_hunter").getString();
			} else if (4 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type")) {
				jobs = Component.translatable("palamod.procedure.jobs_alchi").getString();
			}
		}
	}
}