package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class StockedbaseadminshopbuyProcedure {
	public static double execute(ItemStack itemstack) {
		double num = 0;
		double slotnum = 0;
		if (itemstack.getItem() == PalamodModItems.PALADIUM_INGOT.get()) {
			num = 125;
		} else if (itemstack.getItem() == PalamodModItems.TITANE_INGOT.get()) {
			num = 110;
		} else if (itemstack.getItem() == PalamodModItems.AMETHYST_INGOT.get()) {
			num = 75;
		} else if (itemstack.getItem() == Items.DIAMOND) {
			num = 45;
		} else if (itemstack.getItem() == Items.COAL || itemstack.getItem() == Items.CHARCOAL) {
			num = 5;
		} else if (itemstack.getItem() == Items.GOLD_INGOT) {
			num = 35;
		} else if (itemstack.getItem() == Items.IRON_INGOT) {
			num = 20;
		} else if (itemstack.getItem() == PalamodModItems.FINDIUM.get()) {
			num = 90;
		} else if (itemstack.getItem() == Blocks.DIRT.asItem() || itemstack.getItem() == Blocks.NETHERRACK.asItem() || itemstack.getItem() == Blocks.STONE.asItem()) {
			num = 10;
		} else if (itemstack.getItem() == Blocks.GRASS_BLOCK.asItem()) {
			num = 15;
		} else if (itemstack.getItem() == Blocks.SAND.asItem()) {
			num = 17.5;
		} else if (itemstack.getItem() == Blocks.GRAVEL.asItem()) {
			num = 20;
		} else if (itemstack.getItem() == Blocks.SOUL_SAND.asItem() || itemstack.getItem() == Blocks.OAK_LOG.asItem() || itemstack.getItem() == Blocks.SOUL_SOIL.asItem()) {
			num = 5;
		} else if (itemstack.getItem() == Blocks.BLACKSTONE.asItem()) {
			num = 45;
		} else if (itemstack.getItem() == Blocks.GLOWSTONE.asItem()) {
			num = 10;
		} else if (itemstack.getItem() == Blocks.RED_MUSHROOM.asItem()) {
			num = 5;
		} else if (itemstack.getItem() == Items.STRING) {
			num = 2.25;
		} else if (itemstack.getItem() == Blocks.CACTUS.asItem()) {
			num = 6;
		} else if (itemstack.getItem() == Items.POTATO) {
			num = 4.5;
		} else if (itemstack.getItem() == Items.EGG) {
			num = 10;
		} else if (itemstack.getItem() == Items.REDSTONE) {
			num = 6;
		} else if (itemstack.getItem() == Items.WITHER_SKELETON_SKULL) {
			num = 50000;
		} else if (itemstack.getItem() == Items.SLIME_BALL) {
			num = 8;
		} else if (itemstack.getItem() == Blocks.BROWN_MUSHROOM.asItem()) {
			num = 5;
		} else if (itemstack.getItem() == Blocks.WARPED_FUNGUS.asItem()) {
			num = 7.5;
		} else if (itemstack.getItem() == Blocks.CRIMSON_FUNGUS.asItem()) {
			num = 7.5;
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("minecraft:wool")))) {
			num = 7.5;
		} else if (itemstack.getItem() == Blocks.OBSIDIAN.asItem()) {
			num = 10;
		} else if (itemstack.getItem() == Items.APPLE) {
			num = 7.5;
		} else if (itemstack.getItem() == Items.FERMENTED_SPIDER_EYE) {
			num = 7.5;
		} else if (itemstack.getItem() == Items.QUARTZ) {
			num = 8;
		} else if (itemstack.getItem() == Items.GHAST_TEAR) {
			num = 25;
		} else if (itemstack.getItem() == Items.WHEAT) {
			num = 3;
		} else if (itemstack.getItem() == Items.AMETHYST_SHARD) {
			num = 7;
		} else if (itemstack.getItem() == Items.FLINT) {
			num = 5.5;
		} else if (itemstack.getItem() == Items.FEATHER) {
			num = 13.5;
		} else if (itemstack.getItem() == Items.LEATHER) {
			num = 20;
		} else if (itemstack.getItem() == Items.INK_SAC) {
			num = 12.5;
		} else if (itemstack.getItem() == Items.GLOW_INK_SAC) {
			num = 14.5;
		} else if (itemstack.getItem() == Items.NETHER_WART) {
			num = 6.25;
		} else if (itemstack.getItem() == Items.CARROT) {
			num = 5.5;
		} else if (itemstack.getItem() == Items.HONEYCOMB) {
			num = 16;
		} else if (itemstack.getItem() == Items.BLAZE_ROD) {
			num = 25;
		} else if (itemstack.getItem() == Items.BONE) {
			num = 6.75;
		} else if (itemstack.getItem() == Items.ENDER_PEARL) {
			num = 10.5;
		} else if (itemstack.getItem() == Items.MELON_SLICE) {
			num = 5.8;
		} else if (itemstack.getItem() == Items.COOKED_BEEF) {
			num = 5.75;
		} else if (itemstack.getItem() == Items.GUNPOWDER) {
			num = 6.75;
		} else if (itemstack.getItem() == Items.GLOWSTONE_DUST) {
			num = 18.75;
		} else if (itemstack.getItem() == Blocks.SUGAR_CANE.asItem()) {
			num = 8;
		} else if (itemstack.getItem() == Items.SPIDER_EYE) {
			num = 3.5;
		} else if (itemstack.getItem() == Items.EMERALD) {
			num = 55;
		} else if (itemstack.getItem() == Items.ROTTEN_FLESH) {
			num = 1;
		} else if (itemstack.getItem() == Items.REDSTONE) {
			num = 2.5;
		} else if (itemstack.getItem() == Items.COCOA_BEANS) {
			num = 75;
		} else {
			num = 0;
		}
		return num;
	}
}