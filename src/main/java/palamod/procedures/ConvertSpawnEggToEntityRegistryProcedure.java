package palamod.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

public class ConvertSpawnEggToEntityRegistryProcedure {
	public static String execute(ItemStack itemstack) {
		ItemStack item = ItemStack.EMPTY;
		String output = "";
		item = itemstack.copy();
		output = "minecraft:player";
		if (item.getItem() == Items.COW_SPAWN_EGG) {
			output = "minecraft:cow";
		} else if (item.getItem() == Items.CREEPER_SPAWN_EGG) {
			output = "minecraft:creeper";
		} else if (item.getItem() == Items.WITHER_SPAWN_EGG) {
			output = "minecraft:wither";
		} else if (item.getItem() == Items.SNOW_GOLEM_SPAWN_EGG) {
			output = "minecraft:snow_golem";
		} else if (item.getItem() == Items.ZOMBIE_SPAWN_EGG) {
			output = "minecraft:zombie";
		} else if (item.getItem() == Items.SKELETON_SPAWN_EGG) {
			output = "minecraft:skeleton";
		} else if (item.getItem() == Items.BLAZE_SPAWN_EGG) {
			output = "minecraft:blaze";
		} else if (item.getItem() == Items.SPIDER_SPAWN_EGG) {
			output = "minecraft:spider";
		} else if (item.getItem() == Items.CAVE_SPIDER_SPAWN_EGG) {
			output = "minecraft:cave_spider";
		} else if (item.getItem() == Items.WITCH_SPAWN_EGG) {
			output = "minecraft:witch";
		}
		return output;
	}
}