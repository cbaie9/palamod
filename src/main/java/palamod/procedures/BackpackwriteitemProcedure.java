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
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class BackpackwriteitemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File backpack = new File("");
		File backpack_backup = new File("");
		File backpack_titane = new File("");
		File backpack_paladium = new File("");
		File backpack_endium = new File("");
		com.google.gson.JsonObject main_backpack = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backup = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_titane = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_paladium = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_endium = new com.google.gson.JsonObject();
		double i = 0;
		double i2 = 0;
		double ifull_backup = 0;
		double i_backup = 0;
		boolean exit = false;
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
		if (backpack_backup.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(backpack_backup));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main_backup = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (main_backup.has("noSave")) {
						if (true == main_backup.get("noSave").getAsBoolean()) {
							main_backup.addProperty("noSave", false);
						} else {
							exit = false;
						}
					} else {
						exit = false;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (!exit) {
				if (backpack.exists()) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:backpack")))) {
						i2 = GetslotbackpackProcedure.execute(entity);
						i_backup = 1;
						for (int index502 = 0; index502 < 4; index502++) {
							main_backup.addProperty(("backpack_backup" + Math.round(i_backup)), 0);
							i_backup = i_backup + 1;
						}
						for (int index503 = 0; index503 < (int) i2; index503++) {
							if (i >= 0 && i <= 8) {
								main_backpack.addProperty(("backpack_inv_" + i),
										(BuiltInRegistries.ITEM
												.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get((int) i).getItem() : ItemStack.EMPTY).getItem())
												.toString()));
								main_backpack.addProperty(("backpack_num_" + i), (getAmountInGUISlot(entity, (int) i)));
								main_backup.addProperty("backpack_backup1", (main_backup.get("backpack_backup1").getAsDouble() + getAmountInGUISlot(entity, (int) i)));
							} else if (i >= 9 && i <= 26) {
								main_backpack_titane.addProperty(("backpack_inv_" + i),
										(BuiltInRegistries.ITEM
												.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get((int) i).getItem() : ItemStack.EMPTY).getItem())
												.toString()));
								main_backpack_titane.addProperty(("backpack_num_" + i), (getAmountInGUISlot(entity, (int) i)));
								main_backup.addProperty("backpack_backup2", (main_backup.get("backpack_backup2").getAsDouble() + getAmountInGUISlot(entity, (int) i)));
							} else if (i >= 27 && i <= 53) {
								main_backpack_paladium.addProperty(("backpack_inv_" + i),
										(BuiltInRegistries.ITEM
												.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get((int) i).getItem() : ItemStack.EMPTY).getItem())
												.toString()));
								main_backpack_paladium.addProperty(("backpack_num_" + i), (getAmountInGUISlot(entity, (int) i)));
								main_backup.addProperty("backpack_backup3", (main_backup.get("backpack_backup3").getAsDouble() + getAmountInGUISlot(entity, (int) i)));
							} else if (i >= 54 && i <= 81) {
								main_backpack_endium.addProperty(("backpack_inv_" + i),
										(BuiltInRegistries.ITEM
												.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu53 ? _menu53.getSlots().get((int) i).getItem() : ItemStack.EMPTY).getItem())
												.toString()));
								main_backpack_endium.addProperty(("backpack_num_" + i), (getAmountInGUISlot(entity, (int) i)));
								main_backup.addProperty("backpack_backup4", (main_backup.get("backpack_backup4").getAsDouble() + getAmountInGUISlot(entity, (int) i)));
							}
							ifull_backup = ifull_backup + getAmountInGUISlot(entity, (int) i);
							if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
								_menu.getSlots().get((int) i).set(ItemStack.EMPTY);
								_player.containerMenu.broadcastChanges();
							}
							i = i + 1;
						}
						{
							com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(backpack);
								fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}
						main_backup.addProperty("backpack_asOpened", 1);
						if (i2 >= 27) {
							{
								com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
								try {
									FileWriter fileWriter = new FileWriter(backpack_titane);
									fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack_titane));
									fileWriter.close();
								} catch (IOException exception) {
									exception.printStackTrace();
								}
							}
							main_backup.addProperty("backpack_asOpened", 2);
						}
						if (i2 >= 55) {
							{
								com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
								try {
									FileWriter fileWriter = new FileWriter(backpack_paladium);
									fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack_paladium));
									fileWriter.close();
								} catch (IOException exception) {
									exception.printStackTrace();
								}
							}
							main_backup.addProperty("backpack_asOpened", 3);
						}
						if (i2 >= 82) {
							{
								com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
								try {
									FileWriter fileWriter = new FileWriter(backpack_endium);
									fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack_endium));
									fileWriter.close();
								} catch (IOException exception) {
									exception.printStackTrace();
								}
							}
							main_backup.addProperty("backpack_asOpened", 4);
						}
						main_backup.addProperty("backpack_checksum_writen_slot", i2);
					}
				} else {
					BackpackcreatefileProcedure.execute(world, entity);
					BackpackwriteitemProcedure.execute(world, entity);
				}
			}
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(backpack_backup);
					fileWriter.write(mainGSONBuilderVariable.toJson(main_backup));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof PalamodModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}