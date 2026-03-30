package palamod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class TitlepogProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		ItemStack mainhand = ItemStack.EMPTY;
		double pickaxe_stone = 0;
		String output = "";
		pickaxe_stone = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0);
		mainhand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
		if (pickaxe_stone >= 150000) {
			output = "Fully upgraded - Level 20";
		} else if (pickaxe_stone >= 88582) {
			output = Math.round(2000000 - pickaxe_stone) + " Left - Level 19";
		} else if (pickaxe_stone >= 55598) {
			output = Math.round(1000000 - pickaxe_stone) + " Left - Level 18";
		} else if (pickaxe_stone >= 36485) {
			output = Math.round(800000 - pickaxe_stone) + " Left - Level 17";
		} else if (pickaxe_stone >= 25242) {
			output = Math.round(700000 - pickaxe_stone) + " Left - Level 16";
		} else if (pickaxe_stone >= 14620) {
			output = Math.round(600000 - pickaxe_stone) + " Left - Level 15";
		} else if (pickaxe_stone >= 10000) {
			output = Math.round(500000 - pickaxe_stone) + " Left - Level 14";
		} else if (pickaxe_stone >= 7804) {
			output = Math.round(400000 - pickaxe_stone) + " Left - Level 13";
		} else if (pickaxe_stone >= 6895) {
			output = Math.round(250000 - pickaxe_stone) + " Left - Level 12";
		} else if (pickaxe_stone >= 5403) {
			output = Math.round(150000 - pickaxe_stone) + " Left - Level 11";
		} else if (pickaxe_stone >= 4326) {
			output = Math.round(100000 - pickaxe_stone) + " Left - Level 10";
		} else if (pickaxe_stone >= 3542) {
			output = Math.round(50000 - pickaxe_stone) + " Left - Level 9";
		} else if (pickaxe_stone >= 2138) {
			output = Math.round(25000 - pickaxe_stone) + " Left - Level 8";
		} else if (pickaxe_stone >= 1589) {
			output = Math.round(10000 - pickaxe_stone) + " Left - Level 7";
		} else if (pickaxe_stone >= 1370) {
			output = Math.round(5000 - pickaxe_stone) + " Left - Level 6";
		} else if (pickaxe_stone >= 1172) {
			output = Math.round(2000 - pickaxe_stone) + " Left - Level 5";
		} else if (pickaxe_stone >= 757) {
			output = Math.round(1000 - pickaxe_stone) + " Left - Level 4";
		} else if (pickaxe_stone >= 250) {
			output = Math.round(500 - pickaxe_stone) + " Left - Level 3";
		} else if (pickaxe_stone >= 100) {
			output = Math.round(250 - pickaxe_stone) + " Left - Level 2";
		} else {
			output = Math.round(100 - pickaxe_stone) + " Left - Level 1";
		}
		return output;
	}
}