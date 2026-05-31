package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class TankitemtooltipProcedure {
	public static void execute(ItemStack itemstack) {
		ItemStack output = ItemStack.EMPTY;
		String item_display = "";
		double max_stock = 0;
		if (1 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("tank_type", 0)) {
			item_display = (((new ItemStack(PalamodModBlocks.GOLDEN_TANK.get())).getDisplayName().getString()).replace("[", "")).replace("]", "");
			max_stock = 35;
		} else if (2 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("tank_type", 0)) {
			item_display = (((new ItemStack(PalamodModBlocks.AMETHYST_TANK.get())).getDisplayName().getString()).replace("[", "")).replace("]", "");
			max_stock = 60;
		} else if (3 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("tank_type", 0)) {
			item_display = (((new ItemStack(PalamodModBlocks.TITANE_TANK.get())).getDisplayName().getString()).replace("[", "")).replace("]", "");
			max_stock = 95;
		} else if (4 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("tank_type", 0)) {
			item_display = (((new ItemStack(PalamodModBlocks.PALADIUM_TANK.get())).getDisplayName().getString()).replace("[", "")).replace("]", "");
			max_stock = 135;
		}
		itemstack.set(DataComponents.CUSTOM_NAME,
				Component.literal(((((("%1" + " - " + Component.translatable("palamod.item.tank_item_l2").getString() + " - " + Component.translatable("palamod.item.tank_item_l3").getString()).replace("%4", "" + max_stock)).replace("%3",
						"" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("stock", 0)))
						.replace("%2", itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("type", ""))).replace("%1", item_display))));
	}
}