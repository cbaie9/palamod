package palamod.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class ChecksumProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double output = 0;
		boolean valid = false;
		boolean crusher_valid = false;
		boolean Grinder_valid = false;
		File file = new File("");
		com.google.gson.JsonObject main_obj = new com.google.gson.JsonObject();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/saves/" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "/serverconfig/"), File.separator + "palamod-configuration-custom.json");
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main_obj = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (main_obj.get("Crusher-Custom").getAsBoolean()) {
						if (0 < main_obj.get("Crusher-amethyst-input").getAsDouble() && 0 < main_obj.get("Crusher-titane-input").getAsDouble() && 0 < main_obj.get("Crusher-paladium-input").getAsDouble()
								&& 0 < main_obj.get("Crusher-endium-input").getAsDouble() && 0 <= main_obj.get("Crusher-amethyst-output").getAsDouble() && 64 >= main_obj.get("Crusher-amethyst-output").getAsDouble()
								&& 0 <= main_obj.get("Crusher-titane-output").getAsDouble() && 64 >= main_obj.get("Crusher-titane-output").getAsDouble() && 0 <= main_obj.get("Crusher-paladium-output").getAsDouble()
								&& 64 >= main_obj.get("Crusher-paladium-output").getAsDouble() && 0 <= main_obj.get("Crusher-endium-output").getAsDouble() && 64 >= main_obj.get("Crusher-endium-output").getAsDouble()) {
							crusher_valid = true;
						} else {
							crusher_valid = false;
						}
					} else {
						valid = true;
					}
					if (main_obj.get("Grinder-Custom").getAsBoolean()) {
						if (0 < main_obj.get("Grinder-Capacity").getAsDouble() && 0 < main_obj.get("Grinder-loading_time1").getAsDouble() && 0 < main_obj.get("Grinder-loading_time2").getAsDouble()
								&& 0 < main_obj.get("Grinder-loading_time3").getAsDouble()) {
							Grinder_valid = true;
						} else {
							Grinder_valid = false;
						}
					} else {
						valid = true;
					}
					if (valid) {
						output = Math.round(
								Math.pow(main_obj.get("Grinder-loading_time1").getAsDouble() + main_obj.get("Grinder-loading_time2").getAsDouble() + main_obj.get("Grinder-loading_time3").getAsDouble(), main_obj.get("Grinder-Capacity").getAsDouble())
										* ((Math.pow(main_obj.get("Crusher-amethyst-input").getAsDouble(), main_obj.get("Crusher-titane-input").getAsDouble())
												+ Math.pow(main_obj.get("Crusher-paladium-input").getAsDouble(), main_obj.get("Crusher-endium-input").getAsDouble()))
												/ Math.pow(main_obj.get("Crusher-paladium-output").getAsDouble(), main_obj.get("Crusher-endium-output").getAsDouble()))
										* (main_obj.get("Crusher-titane-output").getAsDouble() + main_obj.get("Crusher-amethyst-output").getAsDouble()));
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Checksum :" + output)), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Valid value :" + valid)), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Crusher cheat : " + main_obj.get("Crusher-Custom").getAsBoolean())), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Crusher :" + main_obj.get("Grinder-Custom").getAsBoolean())), false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
