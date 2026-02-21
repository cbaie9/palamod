package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

public class StockedbaseadminshopsellProcedure {
	public static double execute(ItemStack itemstack) {
		double num = 0;
		double slotnum = 0;
		ItemStack item = ItemStack.EMPTY;
		item = itemstack.copy();
		if (item.getItem() == PalamodModItems.PALADIUM_INGOT.get()) {
			num = 120;
		} else if (item.getItem() == PalamodModItems.TITANE_INGOT.get()) {
			num = 100;
		} else if (item.getItem() == PalamodModItems.AMETHYST_INGOT.get()) {
			num = 70;
		} else if (item.getItem() == Items.DIAMOND) {
			num = 40;
		} else if (item.getItem() == Items.COAL || item.getItem() == Items.CHARCOAL) {
			num = 3;
		} else if (item.getItem() == Items.GOLD_INGOT) {
			num = 30;
		} else if (item.getItem() == Items.IRON_INGOT) {
			num = 15;
		} else if (item.getItem() == PalamodModItems.FINDIUM.get()) {
			num = 85;
		} else if (item.getItem() == Blocks.DIRT.asItem() || item.getItem() == Blocks.NETHERRACK.asItem() || item.getItem() == Blocks.STONE.asItem()) {
			num = 0.1;
		} else if (item.getItem() == Blocks.GRASS_BLOCK.asItem()) {
			num = 0.3;
		} else if (item.getItem() == Blocks.SAND.asItem()) {
			num = 0.4;
		} else if (item.getItem() == Blocks.GRAVEL.asItem()) {
			num = 0.2;
		} else if (item.getItem() == Blocks.SOUL_SAND.asItem() || item.getItem() == Blocks.OAK_LOG.asItem() || item.getItem() == Items.CARROT || item.getItem() == Items.SPIDER_EYE || item.getItem() == Blocks.SOUL_SOIL.asItem()) {
			num = 0.5;
		} else if (item.getItem() == Blocks.BLACKSTONE.asItem()) {
			num = 1;
		} else if (item.getItem() == Blocks.GLOWSTONE.asItem() || item.getItem() == Items.COOKED_BEEF) {
			num = 5;
		} else if (item.getItem() == Blocks.CACTUS.asItem() || item.getItem() == Blocks.WARPED_FUNGUS.asItem() || item.getItem() == Blocks.CRIMSON_FUNGUS.asItem() || item.getItem() == Blocks.RED_MUSHROOM.asItem()
				|| item.getItem() == Blocks.BROWN_MUSHROOM.asItem()) {
			num = 1;
		} else if (item.getItem() == Items.POTATO) {
			num = 0.75;
		} else if (item.getItem() == Items.SLIME_BALL) {
			num = 6;
		} else if (item.getItem() == Items.MELON_SLICE) {
			num = 0.8;
		} else if (item.getItem() == Blocks.WHEAT.asItem()) {
			num = 0.1;
		} else if (item.getItem() == Blocks.SUGAR_CANE.asItem()) {
			num = 4;
		} else if (item.getItem() == Items.ENDER_PEARL) {
			num = 5.5;
		} else if (item.getItem() == Items.EGG) {
			num = 3;
		} else if (item.getItem() == Items.STRING) {
			num = 2.25;
		} else if (item.getItem() == Items.BONE) {
			num = 6.75;
		} else if (item.getItem() == Items.FERMENTED_SPIDER_EYE && item.getItem() == Items.INK_SAC) {
			num = 5.75;
		} else if (item.getItem() == Items.GHAST_TEAR) {
			num = 20;
		} else if (item.getItem() == Blocks.WITHER_SKELETON_SKULL.asItem()) {
			num = 1000;
		} else if (item.getItem() == Items.GUNPOWDER) {
			num = 1.75;
		} else if (item.getItem() == Items.BLAZE_ROD) {
			num = 8.5;
		} else if (item.getItem() == Items.FEATHER || item.getItem() == Items.HONEYCOMB) {
			num = 6.5;
		} else if (item.getItem() == Items.GLOW_INK_SAC || item.getItem() == Items.COCOA_BEANS) {
			num = 6;
		} else if (item.getItem() == PalamodModItems.DISC_FUZEIII.get() || item.getItem() == PalamodModItems.DISC_ANTI_FUZE.get() || item.getItem() == PalamodModItems.DISC_ROULETTE_PALADIENNE.get()) {
			num = 50;
		} else {
			num = 0;
		}
		return num;
	}
}