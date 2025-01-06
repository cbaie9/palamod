package palamod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class MoucepotgProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 150000) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("Fully upgraded - Level 20"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 88582) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(2000000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 19")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 55598) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(1000000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 18")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 36485) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(800000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 17")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 25242) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(700000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 16")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 14620) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(600000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 15")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 10000) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(500000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 14")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 7804) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(400000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 13")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 6895) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(250000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 12")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 5403) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(150000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 11")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 4326) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(100000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 10")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 3542) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(50000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 9")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 2138) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(25000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 8")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 1589) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(10000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 7")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 1370) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(5000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 6")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 1172) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(2000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 5")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 757) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(1000 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 4")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 250) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(500 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 3")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 100) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(250 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 2")));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone") >= 1) {
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(100 - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone")) + " Left - Level 1")));
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Cooldown_name") > 0) {
				{
					final String _tagName = "Cooldown_name";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Cooldown_name") - 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		} else {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.palamod.pickaxeofthegodslv_1").getString())));
		}
	}
}
