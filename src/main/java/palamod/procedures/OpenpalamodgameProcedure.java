package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

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
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

@Mod.EventBusSubscriber
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
		com.google.gson.JsonObject money_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject cache_main = new com.google.gson.JsonObject();
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
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
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
		cache = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + ("cache_" + entity.getUUID().toString() + ".json"));
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
			cache_main.addProperty("block", (ForgeRegistries.BLOCKS.getKey(Blocks.AIR).toString()));
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
}
