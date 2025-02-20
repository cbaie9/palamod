package palamod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;
import java.util.Map;

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
						for (int index0 = 0; index0 < 4; index0++) {
							main_backup.addProperty(("backpack_backup" + Math.round(i_backup)), 0);
							i_backup = i_backup + 1;
						}
						for (int index1 = 0; index1 < (int) i2; index1++) {
							if (i >= 0 && i <= 8) {
								main_backpack.addProperty(("backpack_inv_" + i),
										(BuiltInRegistries.ITEM.getKey(
												(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem())
												.toString()));
								main_backpack.addProperty(("backpack_num_" + i), (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount((int) i)));
								main_backup.addProperty("backpack_backup1", (main_backup.get("backpack_backup1").getAsDouble() + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount((int) i)));
							} else if (i >= 9 && i <= 26) {
								main_backpack_titane.addProperty(("backpack_inv_" + i),
										(BuiltInRegistries.ITEM.getKey(
												(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem())
												.toString()));
								main_backpack_titane.addProperty(("backpack_num_" + i), (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount((int) i)));
								main_backup.addProperty("backpack_backup2", (main_backup.get("backpack_backup2").getAsDouble() + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount((int) i)));
							} else if (i >= 27 && i <= 53) {
								main_backpack_paladium.addProperty(("backpack_inv_" + i),
										(BuiltInRegistries.ITEM.getKey(
												(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem())
												.toString()));
								main_backpack_paladium.addProperty(("backpack_num_" + i), (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount((int) i)));
								main_backup.addProperty("backpack_backup3", (main_backup.get("backpack_backup3").getAsDouble() + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount((int) i)));
							} else if (i >= 54 && i <= 81) {
								main_backpack_endium.addProperty(("backpack_inv_" + i),
										(BuiltInRegistries.ITEM.getKey(
												(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem())
												.toString()));
								main_backpack_endium.addProperty(("backpack_num_" + i), (new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount((int) i)));
								main_backup.addProperty("backpack_backup4", (main_backup.get("backpack_backup4").getAsDouble() + new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount((int) i)));
							}
							ifull_backup = ifull_backup + new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount((int) i);
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								((Slot) _slots.get((int) i)).set(ItemStack.EMPTY);
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
}
