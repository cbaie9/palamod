package palamod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class MoucepotgProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double pickaxe_stone = 0;
		ItemStack mainhand = ItemStack.EMPTY;
		pickaxe_stone = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone");
		mainhand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
		if (entity.isShiftKeyDown()) {
			if (pickaxe_stone >= 150000) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal("Fully upgraded - Level 20"));
			} else if (pickaxe_stone >= 88582) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(2000000 - pickaxe_stone) + " Left - Level 19")));
			} else if (pickaxe_stone >= 55598) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(1000000 - pickaxe_stone) + " Left - Level 18")));
			} else if (pickaxe_stone >= 36485) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(800000 - pickaxe_stone) + " Left - Level 17")));
			} else if (pickaxe_stone >= 25242) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(700000 - pickaxe_stone) + " Left - Level 16")));
			} else if (pickaxe_stone >= 14620) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(600000 - pickaxe_stone) + " Left - Level 15")));
			} else if (pickaxe_stone >= 10000) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(500000 - pickaxe_stone) + " Left - Level 14")));
			} else if (pickaxe_stone >= 7804) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(400000 - pickaxe_stone) + " Left - Level 13")));
			} else if (pickaxe_stone >= 6895) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(250000 - pickaxe_stone) + " Left - Level 12")));
			} else if (pickaxe_stone >= 5403) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(150000 - pickaxe_stone) + " Left - Level 11")));
			} else if (pickaxe_stone >= 4326) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(100000 - pickaxe_stone) + " Left - Level 10")));
			} else if (pickaxe_stone >= 3542) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(50000 - pickaxe_stone) + " Left - Level 9")));
			} else if (pickaxe_stone >= 2138) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(25000 - pickaxe_stone) + " Left - Level 8")));
			} else if (pickaxe_stone >= 1589) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(10000 - pickaxe_stone) + " Left - Level 7")));
			} else if (pickaxe_stone >= 1370) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(5000 - pickaxe_stone) + " Left - Level 6")));
			} else if (pickaxe_stone >= 1172) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(2000 - pickaxe_stone) + " Left - Level 5")));
			} else if (pickaxe_stone >= 757) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(1000 - pickaxe_stone) + " Left - Level 4")));
			} else if (pickaxe_stone >= 250) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(500 - pickaxe_stone) + " Left - Level 3")));
			} else if (pickaxe_stone >= 100) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(250 - pickaxe_stone) + " Left - Level 2")));
			} else if (pickaxe_stone >= 1) {
				mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Math.round(100 - pickaxe_stone) + " Left - Level 1")));
			}
			if (mainhand.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Cooldown_name") > 0) {
				{
					final String _tagName = "Cooldown_name";
					final double _tagValue = (mainhand.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Cooldown_name") - 1);
					CustomData.update(DataComponents.CUSTOM_DATA, mainhand, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		} else {
			mainhand.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.palamod.pickaxeofthegodslv_1").getString())));
		}
	}
}