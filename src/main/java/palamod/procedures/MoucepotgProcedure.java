package palamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class MoucepotgProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 150000) {
				itemstack.setHoverName(Component.literal("Fully upgraded - Level 20"));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 88582) {
				itemstack.setHoverName(Component.literal((Math.round(2000000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 19")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 55598) {
				itemstack.setHoverName(Component.literal((Math.round(1000000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 18")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 36485) {
				itemstack.setHoverName(Component.literal((Math.round(800000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 17")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 25242) {
				itemstack.setHoverName(Component.literal((Math.round(700000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 16")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 14620) {
				itemstack.setHoverName(Component.literal((Math.round(600000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 15")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 10000) {
				itemstack.setHoverName(Component.literal((Math.round(500000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 14")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 7804) {
				itemstack.setHoverName(Component.literal((Math.round(400000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 13")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 6895) {
				itemstack.setHoverName(Component.literal((Math.round(250000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 12")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 5403) {
				itemstack.setHoverName(Component.literal((Math.round(150000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 11")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 4326) {
				itemstack.setHoverName(Component.literal((Math.round(100000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 10")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 3542) {
				itemstack.setHoverName(Component.literal((Math.round(50000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 9")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 2138) {
				itemstack.setHoverName(Component.literal((Math.round(25000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 8")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 1589) {
				itemstack.setHoverName(Component.literal((Math.round(10000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 7")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 1370) {
				itemstack.setHoverName(Component.literal((Math.round(5000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 6")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 1172) {
				itemstack.setHoverName(Component.literal((Math.round(2000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 5")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 757) {
				itemstack.setHoverName(Component.literal((Math.round(1000 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 4")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 250) {
				itemstack.setHoverName(Component.literal((Math.round(500 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 3")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 100) {
				itemstack.setHoverName(Component.literal((Math.round(250 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 2")));
			} else if (itemstack.getOrCreateTag().getDouble("Pickaxe_stone") >= 1) {
				itemstack.setHoverName(Component.literal((Math.round(100 - itemstack.getOrCreateTag().getDouble("Pickaxe_stone")) + " Left - Level 1")));
			}
			if (itemstack.getOrCreateTag().getDouble("Cooldown_name") > 0) {
				itemstack.getOrCreateTag().putDouble("Cooldown_name", (itemstack.getOrCreateTag().getDouble("Cooldown_name") - 1));
			}
		} else {
			itemstack.setHoverName(Component.literal((Component.translatable("item.palamod.pickaxeofthegodslv_1").getString())));
		}
	}
}
