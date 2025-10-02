package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class StockedbaseadminshopbuyProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double num = 0;
		double slotnum = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DOWNLOADER.get()) {
			slotnum = 3;
		} else {
			slotnum = 0;
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()) {
			num = 125;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == PalamodModItems.TITANE_INGOT.get()) {
			num = 110;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == PalamodModItems.AMETHYST.get()) {
			num = 75;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.DIAMOND) {
			num = 45;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.COAL || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.CHARCOAL) {
			num = 5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.GOLD_INGOT) {
			num = 35;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.IRON_INGOT) {
			num = 20;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == PalamodModItems.FINDIUM.get()) {
			num = 90;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.DIRT.asItem()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.NETHERRACK.asItem()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.STONE.asItem()) {
			num = 10;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.GRASS_BLOCK.asItem()) {
			num = 15;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.SAND.asItem()) {
			num = 17.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.GRAVEL.asItem()) {
			num = 20;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.SOUL_SAND.asItem()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.OAK_LOG.asItem()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.SOUL_SOIL.asItem()) {
			num = 5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.BLACKSTONE.asItem()) {
			num = 45;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.GLOWSTONE.asItem()) {
			num = 10;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.RED_MUSHROOM.asItem()) {
			num = 5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.STRING) {
			num = 2.25;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.CACTUS.asItem()) {
			num = 6;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.POTATO) {
			num = 4.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.EGG) {
			num = 10;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.REDSTONE) {
			num = 6;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.WITHER_SKELETON_SKULL) {
			num = 50000;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.SLIME_BALL) {
			num = 8;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.BROWN_MUSHROOM.asItem()) {
			num = 5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.WARPED_FUNGUS.asItem()) {
			num = 7.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.CRIMSON_FUNGUS.asItem()) {
			num = 7.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.WHITE_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.ORANGE_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.MAGENTA_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.LIGHT_BLUE_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.YELLOW_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.LIME_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.PINK_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.GRAY_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.LIGHT_GRAY_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.CYAN_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.PURPLE_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.BLUE_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.BROWN_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.GREEN_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.RED_WOOL.asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.BLACK_WOOL.asItem()) {
			num = 7.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.OBSIDIAN.asItem()) {
			num = 10;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.APPLE) {
			num = 7.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.FERMENTED_SPIDER_EYE) {
			num = 7.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.QUARTZ) {
			num = 8;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.GHAST_TEAR) {
			num = 25;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.WHEAT_SEEDS) {
			num = 0.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.AMETHYST_SHARD) {
			num = 7;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.FLINT) {
			num = 5.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.FEATHER) {
			num = 13.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.LEATHER) {
			num = 20;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.INK_SAC) {
			num = 12.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.GLOW_INK_SAC) {
			num = 14.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.NETHER_WART) {
			num = 6.25;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.CARROT) {
			num = 5.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.HONEYCOMB) {
			num = 16;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.BLAZE_ROD) {
			num = 25;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.BONE) {
			num = 6.75;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.ENDER_PEARL) {
			num = 10.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.MELON_SLICE) {
			num = 5.8;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.COOKED_BEEF) {
			num = 5.75;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.GUNPOWDER) {
			num = 6.75;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.GLOWSTONE_DUST) {
			num = 18.75;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Blocks.SUGAR_CANE.asItem()) {
			num = 8;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.SPIDER_EYE) {
			num = 3.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.EMERALD) {
			num = 55;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.ROTTEN_FLESH) {
			num = 1;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.REDSTONE) {
			num = 2.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) slotnum).copy()).getItem() == Items.COCOA_BEANS) {
			num = 75;
		} else {
			num = 0;
		}
		return num;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}