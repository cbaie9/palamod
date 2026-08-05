package palamod.procedures;

import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetxpminerbreakblockProcedure {
	public static double execute(LevelAccessor world, BlockState palahelpBlock, Entity entity, boolean palahelpOverride, double level_miner) {
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
		cache = ReadcacheProcedure.execute(entity);
		lvl = level_miner;
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
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:hammer_smt"))) && !palahelpOverride) {
						for (int index781 = 0; index781 < 9; index781++) {
							block = BuiltInRegistries.BLOCK.get(ResourceLocation.parse((cache_main.get((8 == nloop ? "block" : "block_hammer_cache_" + nloop)).getAsString()).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
							if (block.getBlock() == Blocks.DEEPSLATE || block.getBlock() == Blocks.STONE) {
								output = output + 0.5;
							} else if (block.getBlock() == Blocks.DIORITE) {
								output = output + 3;
							} else if (block.getBlock() == Blocks.GRANITE) {
								output = output + 3;
							} else if (block.getBlock() == Blocks.ANDESITE) {
								output = output + 3;
							} else if (block.getBlock() == Blocks.COAL_ORE || block.getBlock() == Blocks.COAL_ORE || block.getBlock() == PalamodModBlocks.SOFTENED_COAL_ORE.get()) {
								output = output + 4;
							} else if (block.getBlock() == Blocks.NETHER_QUARTZ_ORE) {
								output = output + 6;
							} else if (block.getBlock() == Blocks.OBSIDIAN) {
								output = output + 6;
							} else if (block.getBlock() == Blocks.REDSTONE_ORE || block.getBlock() == PalamodModBlocks.SOFTENED_REDSTONE_ORE.get() || block.getBlock() == Blocks.DEEPSLATE_REDSTONE_ORE) {
								output = output + 15;
							} else if (block.getBlock() == Blocks.EMERALD_ORE || block.getBlock() == Blocks.DEEPSLATE_EMERALD_ORE) {
								output = output + 50;
							} else if (block.getBlock() == Blocks.DIAMOND_ORE || block.getBlock() == PalamodModBlocks.SOFTENED_DIAMOND_ORE.get() || block.getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE) {
								if (10 <= lvl) {
									output = output + 25;
								}
							} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt")))) != 0) {
								output = output + GetXpcraftjobsProcedure.execute((world instanceof Level _lvlSmeltResult
										? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack(block.getBlock()))), _lvlSmeltResult)
												.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
										: ItemStack.EMPTY), 0, 0, 0, level_miner, "smelt");
							}
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:hammer_smt")))) {
								nloop = nloop + 1;
							} else {
								break;
							}
							if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
								PalamodMod.LOGGER
										.debug(((("[GetXpminerbreakblock] Loop %1 - block : %2 - actual count  : %3".replace("%3", "" + output)).replace("%2", BuiltInRegistries.BLOCK.getKey(block.getBlock()).toString())).replace("%1", "" + nloop)));
							}
						}
					} else {
						block = (palahelpOverride ? palahelpBlock : BuiltInRegistries.BLOCK.get(ResourceLocation.parse((cache_main.get("block").getAsString()).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState());
						if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt")))) != 0)) {
							if (block.getBlock() == Blocks.DEEPSLATE || block.getBlock() == Blocks.STONE) {
								output = output + 0.5;
							} else if (block.getBlock() == Blocks.DIORITE) {
								output = output + 3;
							} else if (block.getBlock() == Blocks.GRANITE) {
								output = output + 3;
							} else if (block.getBlock() == Blocks.ANDESITE) {
								output = output + 3;
							} else if (block.getBlock() == Blocks.COAL_ORE || block.getBlock() == PalamodModBlocks.SOFTENED_COAL_ORE.get() || block.getBlock() == Blocks.DEEPSLATE_COAL_ORE) {
								output = output + 4;
							} else if (block.getBlock() == Blocks.NETHER_QUARTZ_ORE) {
								output = output + 6;
							} else if (block.getBlock() == Blocks.OBSIDIAN) {
								output = output + 6;
							} else if (block.getBlock() == Blocks.REDSTONE_ORE || block.getBlock() == PalamodModBlocks.SOFTENED_REDSTONE_ORE.get() || block.getBlock() == Blocks.DEEPSLATE_REDSTONE_ORE) {
								output = output + 15;
							} else if (block.getBlock() == Blocks.EMERALD_ORE || block.getBlock() == Blocks.DEEPSLATE_EMERALD_ORE) {
								output = output + 50;
							} else if (block.getBlock() == Blocks.DIAMOND_ORE || block.getBlock() == PalamodModBlocks.SOFTENED_DIAMOND_ORE.get() || block.getBlock() == Blocks.DEEPSLATE_DIAMOND_ORE) {
								if (10 < lvl) {
									output = output + 25;
								}
							}
						} else {
							output = GetXpcraftjobsProcedure.execute((world instanceof Level _lvlSmeltResult
									? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack(block.getBlock()))), _lvlSmeltResult)
											.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
									: ItemStack.EMPTY), 0, 0, 0, level_miner, "smelt");
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return output;
	}
}