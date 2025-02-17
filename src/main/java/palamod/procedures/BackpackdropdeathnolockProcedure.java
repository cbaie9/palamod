package palamod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class BackpackdropdeathnolockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ifull_backup = 0;
		double i2 = 0;
		double i = 0;
		File backpack_titane = new File("");
		File backpack_endium = new File("");
		File backpack = new File("");
		File backpack_paladium = new File("");
		File backpack_backup = new File("");
		com.google.gson.JsonObject main_backpaclk1 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack2 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack3 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack4 = new com.google.gson.JsonObject();
		backpack = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backpack_1.json");
		backpack_titane = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backpack_2.json");
		backpack_paladium = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backpack_3.json");
		backpack_endium = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backpack_4.json");
		backpack_backup = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backup.json");
		if (backpack.exists()) {
			i2 = GetslotbackpackProcedure.execute(entity);
			i = 0;
			if (i2 >= 0) {
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(backpack));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						main_backpaclk1 = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						for (int index0 = 0; index0 < 9; index0++) {
							for (int index1 = 0; index1 < (int) main_backpaclk1.get(("backpack_num_" + i)).getAsDouble(); index1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
											new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse((main_backpaclk1.get(("backpack_inv_" + i)).getAsString()).toLowerCase(java.util.Locale.ENGLISH)))));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							i = i + 1;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if (i2 >= 9) {
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(backpack_titane));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						main_backpack2 = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						for (int index2 = 0; index2 < 18; index2++) {
							for (int index3 = 0; index3 < (int) main_backpack2.get(("backpack_num_" + i)).getAsDouble(); index3++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
											new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse((main_backpack2.get(("backpack_inv_" + i)).getAsString()).toLowerCase(java.util.Locale.ENGLISH)))));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
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
						BufferedReader bufferedReader = new BufferedReader(new FileReader(backpack_paladium));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						main_backpack3 = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						for (int index4 = 0; index4 < 28; index4++) {
							for (int index5 = 0; index5 < (int) main_backpack3.get(("backpack_num_" + i)).getAsDouble(); index5++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
											new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse((main_backpack3.get(("backpack_inv_" + i)).getAsString()).toLowerCase(java.util.Locale.ENGLISH)))));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							i = i + 1;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if (i2 >= 55) {
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(backpack_endium));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						main_backpack4 = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						for (int index6 = 0; index6 < 27; index6++) {
							for (int index7 = 0; index7 < (int) main_backpack4.get(("backpack_num_" + i)).getAsDouble(); index7++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
											new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse((main_backpack4.get(("backpack_inv_" + i)).getAsString()).toLowerCase(java.util.Locale.ENGLISH)))));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							i = i + 1;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			for (int index8 = 0; index8 < 81; index8++) {
				if (i >= 0 && i <= 8) {
					main_backpaclk1.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
					main_backpaclk1.addProperty(("backpack_num_" + i), 0);
				} else if (i >= 9 && i <= 26) {
					main_backpack2.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
					main_backpack2.addProperty(("backpack_num_" + i), 0);
				} else if (i >= 27 && i <= 54) {
					main_backpack3.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
					main_backpack3.addProperty(("backpack_num_" + i), 0);
				} else if (i >= 55 && i <= 80) {
					main_backpack4.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
					main_backpack4.addProperty(("backpack_num_" + i), 0);
				}
				i = i + 1;
			}
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(backpack);
					fileWriter.write(mainGSONBuilderVariable.toJson(main_backpaclk1));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(backpack_titane);
					fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack2));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(backpack_paladium);
					fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack3));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(backpack_endium);
					fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack4));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
