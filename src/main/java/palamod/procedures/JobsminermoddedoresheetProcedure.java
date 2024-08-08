package palamod.procedures;

import palamod.init.PalamodModBlocks;

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

public class JobsminermoddedoresheetProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		File cache = new File("");
		com.google.gson.JsonObject cache_main = new com.google.gson.JsonObject();
		BlockState block = Blocks.AIR.defaultBlockState();
		double blockstate_value = 0;
		double output = 0;
		cache = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + ("cache_" + entity.getUUID().toString() + ".json"));
		if (cache.exists()) {
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
					blockstate_value = cache_main.get("last_block_state").getAsDouble();
					block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation((cache_main.get("block").getAsString()).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
					if (block.getBlock() == PalamodModBlocks.PALADIUM_ORE.get() || block.getBlock() == PalamodModBlocks.DEEPSLATE_PALADIUM_ORE.get()) {
						output = 150;
					} else if (block.getBlock() == PalamodModBlocks.TITANE_ORE.get() || block.getBlock() == PalamodModBlocks.DEEPSLATE_TITANE_ORE.get()) {
						output = 50;
					} else if (block.getBlock() == PalamodModBlocks.AMETHYST_ORE.get() || block.getBlock() == PalamodModBlocks.DEEPSLATE_AMETHYST_ORE.get()) {
						output = 35;
					} else if (block.getBlock() == PalamodModBlocks.FINDIUM_ORE.get() || block.getBlock() == PalamodModBlocks.DEEPSLATE_FINDIUM_ORE.get()) {
						output = 110;
					} else if (block.getBlock() == PalamodModBlocks.PALADIUM_GREEN_ORE.get() || block.getBlock() == PalamodModBlocks.DEEPSLATE_GREEN_PALADIUM_ORE.get()) {
						output = 200;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return output;
	}
}
