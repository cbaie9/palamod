package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class TooltiprenderingprocessProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		String jobs = "";
		if (itemstack.getItem() == PalamodModItems.XPBOTTLE.get()) {
			tooltip.add(1, Component.literal((Component.translatable("palamod.procedure.get_info_xpbottle1").getString())));
			tooltip.add(2, Component.literal((Component.translatable("palamod.procedure.get_info_xpbottle2").getString() + " " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xp_jobs"))));
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
			tooltip.add(3, Component.literal((Component.translatable("palamod.procedure.get_info_xpbottle3").getString() + " " + jobs)));
		}
	}
}