package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class ModdedorejobsminergivexpProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean money_getadd = false;
		File jobs = new File("");
		File money = new File("");
		File cache = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject cache_main = new com.google.gson.JsonObject();
		double lvl = 0;
		double money_add = 0;
		double blockstate = 0;
		double get_lvl_needed = 0;
		double xp_reward = 0;
		BlockState block = Blocks.AIR.defaultBlockState();
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
		cache = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "\\jobs\\" + entity.getUUID().toString()), File.separator + "cache_jobs.json");
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "\\jobs\\" + entity.getUUID().toString()), File.separator + "jobs.json");
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
					blockstate = cache_main.get("last_block_state").getAsDouble();
					block = BuiltInRegistries.BLOCK.get(ResourceLocation.parse((cache_main.get("block").getAsString()).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			xp_reward = JobsminermoddedoresheetlvlProcedure.execute(world, entity);
			if (0 == blockstate) {
				if (jobs.exists() && !(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity)) && money.exists()) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							if (world.dayTime() > main.get("xpstreak_time_miner").getAsDouble()) {
								main.addProperty("xpstreak_miner", 0);
							}
							if (0 < xp_reward) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:botteled")))) != 0
										&& (0 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type")
												|| 1 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type"))
										&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.XPBOTTLE.get()) {
									{
										final String _tagName = "xp_jobs";
										final double _tagValue = (xp_reward * main.get("multi_exp").getAsDouble()
												+ (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xp_jobs"));
										CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
									}
									{
										final String _tagName = "jobs_type";
										final double _tagValue = 1;
										CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
									}
								} else {
									main.addProperty("xp_miner", ((xp_reward / 2) * main.get("multi_exp").getAsDouble() + main.get("xp_miner").getAsDouble()));
								}
								main.addProperty("xpstreak_miner", ((xp_reward / 2) * main.get("multi_exp").getAsDouble() + main.get("xpstreak_miner").getAsDouble()));
								main.addProperty("xpstreak_time_miner", (world.dayTime() + 80));
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(
											Component.literal((Component.translatable("palamod.procedure.jobswin1").getString() + "" + main.get("xpstreak_miner").getAsDouble() + Component.translatable("palamod.procedure.jobswin2").getString() + " "
													+ Component.translatable(("block.palamod." + (BuiltInRegistries.BLOCK.getKey(block.getBlock()).toString()).replace("palamod:", ""))).getString())),
											true);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					{
						com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
						try {
							FileWriter fileWriter = new FileWriter(jobs);
							fileWriter.write(mainGSONBuilderVariable.toJson(main));
							fileWriter.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}
				}
			}
		}
	}
}
