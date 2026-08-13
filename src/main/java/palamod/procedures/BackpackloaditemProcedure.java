package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class BackpackloaditemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack item = ItemStack.EMPTY;
		double i2 = 0;
		double i = 0;
		double backpack_num = 0;
		double ifull_backup = 0;
		File backpack = new File("");
		File backpack_titane = new File("");
		File backpack_endium = new File("");
		File backpack_paladium = new File("");
		File backpack_backup = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_titane = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_paladium = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_endium = new com.google.gson.JsonObject();
		backpack = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getStringUUID()),
				File.separator + "backpack_1.json");
		backpack_titane = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getStringUUID()),
				File.separator + "backpack_2.json");
		backpack_paladium = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getStringUUID()),
				File.separator + "backpack_3.json");
		backpack_endium = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getStringUUID()),
				File.separator + "backpack_4.json");
		backpack_backup = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getStringUUID()),
				File.separator + "backup.json");
		if (backpack.exists()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:backpack")))) {
				i2 = GetslotbackpackProcedure.execute(entity);
				i = 0;
				if (i2 >= 9) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(backpack));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							for (int index71 = 0; index71 < 9; index71++) {
								if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
									ItemStack _setstack27 = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse((main.get(("backpack_inv_" + i)).getAsString()).toLowerCase(java.util.Locale.ENGLISH)))).copy();
									_setstack27.setCount((int) (64 < main.get(("backpack_num_" + i)).getAsDouble() ? 64 : main.get(("backpack_num_" + i)).getAsDouble()));
									_menu.getSlots().get((int) i).set(_setstack27);
									_player.containerMenu.broadcastChanges();
								}
								i = i + 1;
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				if (i2 >= 27) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(backpack_titane));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							main_backpack_titane = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							for (int index72 = 0; index72 < 18; index72++) {
								if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
									ItemStack _setstack33 = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse((main_backpack_titane.get(("backpack_inv_" + i)).getAsString()).toLowerCase(java.util.Locale.ENGLISH)))).copy();
									_setstack33.setCount((int) (64 < main_backpack_titane.get(("backpack_num_" + i)).getAsDouble() ? 64 : main_backpack_titane.get(("backpack_num_" + i)).getAsDouble()));
									_menu.getSlots().get((int) i).set(_setstack33);
									_player.containerMenu.broadcastChanges();
								}
								i = i + 1;
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				if (i2 >= 54) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(backpack_paladium));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							main_backpack_paladium = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							for (int index73 = 0; index73 < 27; index73++) {
								if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
									ItemStack _setstack39 = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse((main_backpack_paladium.get(("backpack_inv_" + i)).getAsString()).toLowerCase(java.util.Locale.ENGLISH)))).copy();
									_setstack39.setCount((int) (64 < main_backpack_paladium.get(("backpack_num_" + i)).getAsDouble() ? 64 : main_backpack_paladium.get(("backpack_num_" + i)).getAsDouble()));
									_menu.getSlots().get((int) i).set(_setstack39);
									_player.containerMenu.broadcastChanges();
								}
								i = i + 1;
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				if (i2 >= 81) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(backpack_endium));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							main_backpack_endium = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							for (int index74 = 0; index74 < 27; index74++) {
								if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
									ItemStack _setstack45 = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse((main_backpack_endium.get(("backpack_inv_" + i)).getAsString()).toLowerCase(java.util.Locale.ENGLISH)))).copy();
									_setstack45.setCount((int) (64 < main_backpack_endium.get(("backpack_num_" + i)).getAsDouble() ? 64 : main_backpack_endium.get(("backpack_num_" + i)).getAsDouble()));
									_menu.getSlots().get((int) i).set(_setstack45);
									_player.containerMenu.broadcastChanges();
								}
								i = i + 1;
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} else {
			BackpackcreatefileProcedure.execute(world, entity);
			BackpackwriteitemProcedure.execute(world, entity);
		}
	}
}