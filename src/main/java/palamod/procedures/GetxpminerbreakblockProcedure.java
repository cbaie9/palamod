package palamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetxpminerbreakblockProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double output = 0;
		double blockstate_value = 0;
		double nloop = 0;
		double lvl = 0;
		File cache = new File("");
		File jobs = new File("");
		BlockState block = Blocks.AIR.defaultBlockState();
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject cache_main = new com.google.gson.JsonObject();
		cache = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + ("cache_" + entity.getUUID().toString() + ".json"));
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(cache));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					cache_main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					for (int index0 = 0; index0 < 9; index0++) {
						block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation((cache_main.get((8 == nloop ? "block" : "block_hammer_cache_" + nloop)).getAsString()).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
						if (block.getBlock() == Blocks.DEEPSLATE || block.getBlock() == Blocks.STONE) {
							output = output + 0.5;
						} else if (block.getBlock() == Blocks.DIORITE) {
							output = output + 3;
						} else if (block.getBlock() == Blocks.GRANITE) {
							output = output + 3;
						} else if (block.getBlock() == Blocks.ANDESITE) {
							output = output + 3;
						} else if (block.getBlock() == Blocks.COAL_ORE || block.getBlock() == Blocks.DEEPSLATE_COAL_ORE) {
							output = output + 4;
						} else if (block.getBlock() == Blocks.NETHER_QUARTZ_ORE) {
							output = output + 6;
						} else if (block.getBlock() == Blocks.OBSIDIAN) {
							output = output + 6;
						} else if (block.getBlock() == Blocks.REDSTONE_ORE || block.getBlock() == Blocks.REDSTONE_ORE || block.getBlock() == Blocks.DEEPSLATE_REDSTONE_ORE) {
							output = output + 15;
						} else if (block.getBlock() == Blocks.EMERALD_ORE || block.getBlock() == Blocks.DEEPSLATE_EMERALD_ORE) {
							output = output + 50;
						} else if (block.getBlock() == Blocks.DIAMOND_ORE || block.getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE) {
							if (10 < lvl) {
								output = output + 25;
							}
						}
						nloop = nloop + 1;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return output;
	}
}
