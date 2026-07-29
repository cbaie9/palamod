package palamod.procedures;

import palamod.init.PalamodModGameRules;
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
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

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
						"tellraw @p {\"text\":\"First lunch or reset of settings,multiplayers services has been started\",\"color\":\"green\"}");
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
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putBoolean(("online_player_" + entity.getDisplayName().getString()), true);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"--------------------------\\nPowered by\",\"color\":\"yellow\"},{\"text\":\" Palamod Renew\",\"color\":\"#2ED0FF\"},{\"text\":\"\\n\"},{\"text\":\"Based on\",\"color\":\"dark_red\"},{\"text\":\" Paladium\",\"color\":\"gold\"},{\"text\":\"\\n\"},{\"text\":\"--------------------------\",\"color\":\"yellow\"}]");
		if (!world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.DISABLEMONEYGAMERULE)) {
			money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getStringUUID() + ".json"));
		}
		clicker = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\clicker\\" + entity.getStringUUID()),
				File.separator + "clicker_info.json");
		clicker_buildings = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\clicker\\" + entity.getStringUUID()),
				File.separator + "clicker_build.json");
		clicker_ame = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\clicker\\" + entity.getStringUUID()),
				File.separator + "clicker_upgrade.json");
		JobsfilecreateautorepairProcedure.execute(world, entity);
		CreateMoneyFileProcedure.execute(world, entity);
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
			for (int index265 = 0; index265 < 6; index265++) {
				page_building = 1;
				for (int index266 = 0; index266 < 6; index266++) {
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
		ResetXpStreakProcedure.execute(world, entity);
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