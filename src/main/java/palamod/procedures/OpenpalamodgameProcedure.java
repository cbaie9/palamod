package palamod.procedures;

import palamod.init.PalamodModBlocks;

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
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

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
		com.google.gson.JsonObject money_main = new com.google.gson.JsonObject();
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
		if (!(entity.getPersistentData().getBoolean("Paladium_setupnbt") == true)) {
			entity.getPersistentData().putBoolean("Paladium_setupnbt", true);
			entity.getPersistentData().putBoolean("Palamod.alive", true);
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean(("Minage_setlayer_dynamic_enda_" + entity.getDisplayName().getString()), true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
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
		if (!money.exists()) {
			money_main.addProperty("money", 0);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(money);
					fileWriter.write(mainGSONBuilderVariable.toJson(money_main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
