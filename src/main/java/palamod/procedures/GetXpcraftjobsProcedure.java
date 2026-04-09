package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetXpcraftjobsProcedure {
	public static double execute(Entity entity, ItemStack item_craft, String recipe) {
		if (entity == null || recipe == null)
			return 0;
		File jobs = new File("");
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		ItemStack item = ItemStack.EMPTY;
		double output = 0;
		double lvl = 0;
		double lvl_farmer = 0;
		double lvl_hunter = 0;
		double lvl_alchi = 0;
		item = item_craft.copy();
		jobs = GetjobsfileProcedure.execute(entity);
		if (jobs.exists() && jobs.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					jobs_main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					lvl = jobs_main.get("lvl_miner").getAsDouble();
					lvl_farmer = jobs_main.get("lvl_farmer").getAsDouble();
					lvl_hunter = jobs_main.get("lvl_hunter").getAsDouble();
					lvl_alchi = jobs_main.get("lvl_alchi").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (("craft").equals(recipe)) {
				if (item.getItem() == PalamodModItems.FLASK.get()) {
					output = 0.2;
				} else if (item.getItem() == PalamodModBlocks.EXTRACTOR.get().asItem()) {
					output = 20;
				} else if (item.is(ItemTags.create(ResourceLocation.parse("palamod:glueball_tier_one"))) && lvl_alchi >= 6) {
					output = 2;
				} else if (item.is(ItemTags.create(ResourceLocation.parse("palamod:glueball_tier_two"))) && lvl_alchi >= 10) {
					output = 15;
				} else if (item.getItem() == Items.BREAD) {
					output = 1;
				} else if (item.getItem() == Items.PUMPKIN_PIE && lvl_farmer >= 11) {
					output = 4;
				}
			} else if (("smelt").equals(recipe)) {
				if (item.getItem() == Items.NETHER_BRICK) {
					output = 0.1;
				} else if (Items.CHARCOAL == item.getItem()) {
					output = 6;
				} else if (Items.IRON_INGOT == item.getItem() && lvl >= 2) {
					output = 8;
				} else if (Items.GOLD_INGOT == item.getItem() && lvl >= 4) {
					output = 30;
				} else if (PalamodModItems.AMETHYST_INGOT.get() == item.getItem() && lvl >= 5) {
					output = 35;
				} else if (PalamodModItems.TITANE_INGOT.get() == item.getItem() && lvl >= 7) {
					output = 50;
				} else if (PalamodModItems.PALADIUM_INGOT.get() == item.getItem() && lvl >= 10) {
					output = 150;
				} else if (PalamodModItems.GREEN_PALADIUM_INGOT.get() == item.getItem() && lvl >= 12) {
					output = 200;
				} else if (item.is(ItemTags.create(ResourceLocation.parse("palamod:smeltable_corpse_xp")))) {
					output = 10;
				} else if (item.is(ItemTags.create(ResourceLocation.parse("palamod:smeltable_corpse_fish")))) {
					output = 15;
				}
			}
		}
		PalamodMod.LOGGER.info(("[Palamod] [GetXpCraftJobs] return : " + output + " | " + item + " | mode : " + recipe));
		return output;
	}
}