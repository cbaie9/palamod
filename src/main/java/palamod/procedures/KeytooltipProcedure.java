package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

public class KeytooltipProcedure {
	public static void execute(ItemStack itemstack) {
		double max_stock = 0;
		String item_display = "";
		item_display = ((new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH)))).getDisplayName().getString()).replace("[", ""))
				.replace("]", "");
		if (itemstack.getItem() == PalamodModItems.AMETHYST_PORTAL_KEY.get()) {
			max_stock = 1;
		} else if (itemstack.getItem() == PalamodModItems.TITANE_PORTAL_KEY.get()) {
			max_stock = 2;
		} else if (itemstack.getItem() == PalamodModItems.PALADIUM_PORTAL_KEY.get()) {
			max_stock = 4;
		} else if (itemstack.getItem() == PalamodModItems.ENDIUM_PORTAL_KEY.get()) {
			max_stock = 3448;
		}
		itemstack.set(DataComponents.CUSTOM_NAME,
				Component.literal((((("%1" + " - " + "%2 / %3").replace("%3", "" + max_stock)).replace("%2", "" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("key_stock"))).replace("%1", item_display))));
	}
}