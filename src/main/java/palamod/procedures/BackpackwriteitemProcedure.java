package palamod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
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
import java.io.File;

public class BackpackwriteitemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double i = 0;
		double i2 = 0;
		double ifull_backup = 0;
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
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:backpack")))) {
				i2 = GetslotbackpackProcedure.execute(entity);
				for (int index0 = 0; index0 < (int) i2; index0++) {
					if (i >= 0 && i <= 8) {
						main_backpack.addProperty(("backpack_inv_" + i),
								(BuiltInRegistries.ITEM
										.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem())
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
					} else if (i >= 9 && i <= 26) {
						main_backpack_titane.addProperty(("backpack_inv_" + i),
								(BuiltInRegistries.ITEM
										.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem())
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
					} else if (i >= 27 && i <= 53) {
						main_backpack_paladium.addProperty(("backpack_inv_" + i),
								(BuiltInRegistries.ITEM
										.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem())
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
					} else if (i >= 54 && i <= 81) {
						main_backpack_endium.addProperty(("backpack_inv_" + i),
								(BuiltInRegistries.ITEM
										.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem())
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
				}
				main_backup.addProperty("backpack_checksum", ifull_backup);
				main_backup.addProperty("backpack_checksum_writen_slot", i2);
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
			} else {
				BackpackdropdeathnolockProcedure.execute(world, x, y, z, entity);
			}
		} else {
			try {
				backpack.getParentFile().mkdirs();
				backpack.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				backpack_titane.getParentFile().mkdirs();
				backpack_titane.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				backpack_paladium.getParentFile().mkdirs();
				backpack_paladium.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				backpack_endium.getParentFile().mkdirs();
				backpack_endium.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				backpack_backup.getParentFile().mkdirs();
				backpack_backup.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			for (int index1 = 0; index1 < 81; index1++) {
				if (i >= 0 && i <= 8) {
					main_backpack.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
					main_backpack.addProperty(("backpack_num_" + i), 0);
				} else if (i >= 9 && i <= 26) {
					main_backpack_titane.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
					main_backpack_titane.addProperty(("backpack_num_" + i), 0);
				} else if (i >= 27 && i <= 54) {
					main_backpack_paladium.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
					main_backpack_paladium.addProperty(("backpack_num_" + i), 0);
				} else if (i >= 55 && i <= 80) {
					main_backpack_endium.addProperty(("backpack_inv_" + i), (BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem()).toString()));
					main_backpack_endium.addProperty(("backpack_num_" + i), 0);
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
			BackpackwriteitemProcedure.execute(world, x, y, z, entity);
		}
	}
}
