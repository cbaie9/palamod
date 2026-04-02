package palamod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import java.util.Set;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class SpawnCommandProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double dim = 0;
		String dim_id = "";
		File home = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		boolean dim_check = false;
		if (IsgameclientsideProcedure.execute(world, x, y, z)) {
			home = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
					+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\home\\global\\"),
					File.separator + "spawn.json");
		} else if (IsgameserversideProcedure.execute()) {
			home = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/spawn/"), File.separator + "spawn.json");
		}
		if (home.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(home));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (!(main.get("dim_id").getAsString()).equals("" + entity.level().dimension())) {
						if (("" + Level.OVERWORLD).equals(main.get("dim_id").getAsString())) {
							if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _serverLevel) {
								ResourceKey<Level> destinationType = Level.OVERWORLD;
								if (_player.level().dimension() == destinationType)
									return;
								ServerLevel nextLevel = _serverLevel.getServer().getLevel(destinationType);
								if (nextLevel != null) {
									_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), Set.of(), _player.getYRot(), _player.getXRot(), true);
									_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
									for (MobEffectInstance _effectinstance : _player.getActiveEffects())
										_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
									_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
							dim_check = true;
						} else if (("" + Level.NETHER).equals(main.get("dim_id").getAsString())) {
							if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _serverLevel) {
								ResourceKey<Level> destinationType = Level.NETHER;
								if (_player.level().dimension() == destinationType)
									return;
								ServerLevel nextLevel = _serverLevel.getServer().getLevel(destinationType);
								if (nextLevel != null) {
									_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), Set.of(), _player.getYRot(), _player.getXRot(), true);
									_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
									for (MobEffectInstance _effectinstance : _player.getActiveEffects())
										_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
									_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
							dim_check = true;
						} else if (("" + Level.END).equals(main.get("dim_id").getAsString())) {
							if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _serverLevel) {
								ResourceKey<Level> destinationType = Level.END;
								if (_player.level().dimension() == destinationType)
									return;
								ServerLevel nextLevel = _serverLevel.getServer().getLevel(destinationType);
								if (nextLevel != null) {
									_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), Set.of(), _player.getYRot(), _player.getXRot(), true);
									_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
									for (MobEffectInstance _effectinstance : _player.getActiveEffects())
										_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
									_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
							dim_check = true;
						} else {
							dim_check = false;
						}
					} else {
						dim_check = true;
					}
					if (dim_check) {
						{
							Entity _ent = entity;
							_ent.teleportTo(main.get("spawn_x").getAsDouble(), main.get("spawn_y").getAsDouble(), main.get("spawn_z").getAsDouble());
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(main.get("spawn_x").getAsDouble(), main.get("spawn_y").getAsDouble(), main.get("spawn_z").getAsDouble(), _ent.getYRot(), _ent.getXRot());
						}
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"tellraw @p [\"\",{\"text\":\"[ \",\"color\":\"dark_red\"},{\"text\":\"Palamod\",\"color\":\"gold\"},{\"text\":\" ]\",\"color\":\"dark_red\"},{\"text\":\" : The dimension where the spawn is doesn't support switching dimension, if this is a problem report to your adminstrator\",\"color\":\"gold\"}]");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}