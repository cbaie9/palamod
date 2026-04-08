package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
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
	public static double execute(Entity entity, ItemStack item_craft) {
		if (entity == null)
			return 0;
		File cache = new File("");
		File jobs = new File("");
		BlockState block = Blocks.AIR.defaultBlockState();
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject cache_main = new com.google.gson.JsonObject();
		ItemStack item = ItemStack.EMPTY;
		double output = 0;
		double blockstate_value = 0;
		double nloop = 0;
		double lvl = 0;
		double lvl_farmer = 0;
		double lvl_hunter = 0;
		double lvl_alchi = 0;
		item = item_craft.copy();
		jobs = GetjobsfileProcedure.execute(entity);
		cache = ReadcacheProcedure.execute(entity);
		if (cache.exists() && jobs.exists()) {
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
		}
		PalamodMod.LOGGER.info(("[Palamod] [GetXpCraftJobs] return : " + output + " | " + item));
		return output;
	}
}