package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@EventBusSubscriber
public class OpenpalamodgameProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File money = new File("");
		File jobs = new File("");
		File cache = new File("");
		File clicker = new File("");
		File clicker_buildings = new File("");
		File clicker_ame = new File("");
		com.google.gson.JsonObject money_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject cache_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject click_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject clicker_buidings = new com.google.gson.JsonObject();
		com.google.gson.JsonObject clicker_ame_main = new com.google.gson.JsonObject();
		double i = 0;
		double page_clicker = 0;
		double page_building = 0;
		if (getEntityGameType(entity) == GameType.CREATIVE) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @s [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" Certain jobs feature are not available in creative due to json structure\",\"color\":\"gold\"}]");
		}
		if (!((world.getBlockState(new BlockPos(0, 10, 0))).getBlock() == PalamodModBlocks.NBT_BLOCK.get())) {
			LunchallsetupProcedure.execute(world);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p {\"text\":\"mip has been started\",\"color\":\"green\"}");
		}
		if (ModList.get().isLoaded("journeymap")) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [\"\",{\"text\":\"[ Warning ]\",\"color\":\"dark_red\"},{\"text\":\" :\",\"color\":\"gold\"},{\"text\":\"" + "" + Component.translatable("palamod.procedure.joinwarning_journeymap").getString()
								+ "\",\"color\":\"aqua\"}]"));
		}
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(0, 10, 0);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean(("online_player_" + entity.getDisplayName().getString()), true);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"--------------------------\\nPowered by\",\"color\":\"yellow\"},{\"text\":\" Palamod Renew\",\"color\":\"#2ED0FF\"},{\"text\":\"\\n\"},{\"text\":\"Based on\",\"color\":\"dark_red\"},{\"text\":\" Paladium\",\"color\":\"gold\"},{\"text\":\"\\n\"},{\"text\":\"--------------------------\",\"color\":\"yellow\"}]");
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "\\jobs\\" + entity.getUUID().toString()), File.separator + "jobs.json");
		cache = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "\\jobs\\" + entity.getUUID().toString()), File.separator + "cache_jobs.json");
		clicker = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\clicker\\" + entity.getUUID().toString()),
				File.separator + "clicker_info.json");
		clicker_buildings = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\clicker\\" + entity.getUUID().toString()),
				File.separator + "clicker_build.json");
		clicker_ame = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\clicker\\" + entity.getUUID().toString()),
				File.separator + "clicker_upgrade.json");
		if (!money.exists()) {
			try {
				money.getParentFile().mkdirs();
				money.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			money_main.addProperty("money", 0);
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(money);
					fileWriter.write(mainGSONBuilderVariable.toJson(money_main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		if (!cache.exists()) {
			try {
				cache.getParentFile().mkdirs();
				cache.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			cache_main.addProperty("last_block_state", (-1));
			cache_main.addProperty("block", (BuiltInRegistries.BLOCK.getKey(Blocks.AIR).toString()));
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(cache);
					fileWriter.write(mainGSONBuilderVariable.toJson(cache_main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		if (!jobs.exists()) {
			try {
				jobs.getParentFile().mkdirs();
				jobs.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			jobs_main.addProperty("multi_exp", 1);
			jobs_main.addProperty("next_level_miner", 50);
			jobs_main.addProperty("next_level_farmer", 480);
			jobs_main.addProperty("next_level_hunter", 480);
			jobs_main.addProperty("next_level_alchi", 480);
			jobs_main.addProperty("lvl_miner", 0);
			jobs_main.addProperty("lvl_farmer", 0);
			jobs_main.addProperty("lvl_hunter", 0);
			jobs_main.addProperty("lvl_alchi", 0);
			jobs_main.addProperty("xp_miner", 0);
			jobs_main.addProperty("xp_farmer", 0);
			jobs_main.addProperty("xp_hunter", 0);
			jobs_main.addProperty("xp_alchi", 0);
			jobs_main.addProperty("xpstreak_miner", 0);
			jobs_main.addProperty("xpstreak_time_miner", 0);
			jobs_main.addProperty("xpstreak_time_farmer", 0);
			jobs_main.addProperty("xpstreak_farmer", 0);
			jobs_main.addProperty("xpstreak_time_hunter", 0);
			jobs_main.addProperty("xpstreak_hunter", 0);
			jobs_main.addProperty("xpstreak_time_alchi", 0);
			jobs_main.addProperty("xpstreak_alchi", 0);
			jobs_main.addProperty("last_unlocked_lvl", 0);
			jobs_main.addProperty("last_unlocked_type", 0);
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(jobs);
					fileWriter.write(mainGSONBuilderVariable.toJson(jobs_main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		} else {
			if (!(money_main.has("last_unlocked_lvl") && money_main.has("last_unlocked_type"))) {
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
						jobs_main.addProperty("last_unlocked_lvl", 0);
						jobs_main.addProperty("last_unlocked_type", 0);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(jobs);
						fileWriter.write(mainGSONBuilderVariable.toJson(jobs_main));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
		if (!clicker.exists()) {
			try {
				clicker.getParentFile().mkdirs();
				clicker.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			click_main.addProperty("coin", 0);
			click_main.addProperty("cps_active", 1);
			click_main.addProperty("cps", 0);
			click_main.addProperty("last_time_cps_unix", GetcustomunixProcedure.execute());
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(clicker);
					fileWriter.write(mainGSONBuilderVariable.toJson(click_main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		if (!clicker_buildings.exists()) {
			try {
				clicker_buildings.getParentFile().mkdirs();
				clicker_buildings.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			page_clicker = 1;
			for (int index0 = 0; index0 < 6; index0++) {
				page_building = 1;
				for (int index1 = 0; index1 < 6; index1++) {
					clicker_buidings.addProperty(("building_p" + Math.round(page_clicker) + "_n" + Math.round(page_building)), 0);
					page_building = page_building + 1;
				}
				page_clicker = page_clicker + 1;
			}
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(clicker_buildings);
					fileWriter.write(mainGSONBuilderVariable.toJson(clicker_buidings));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		OpenModProcedure.execute();
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
