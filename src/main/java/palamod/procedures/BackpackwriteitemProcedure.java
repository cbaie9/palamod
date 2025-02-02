package palamod.procedures;

import palamod.world.inventory.InventorybackupMenu;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import io.netty.buffer.Unpooled;

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
		backpack = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/backpack/"), File.separator + (entity.getUUID().toString() + "_1.json"));
		backpack_titane = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/backpack/"), File.separator + (entity.getUUID().toString() + "_2.json"));
		backpack_paladium = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/backpack/"), File.separator + (entity.getUUID().toString() + "_3.json"));
		backpack_endium = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/backpack/"), File.separator + (entity.getUUID().toString() + "_4.json"));
		backpack_backup = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/backpack/"), File.separator + (entity.getUUID().toString() + "_backup.json"));
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
					} else if (i >= 27 && i <= 54) {
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
					} else if (i >= 55 && i <= 80) {
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
				if (i2 > 9) {
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
				if (i2 > 27) {
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
				if (i2 > 54) {
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
				if (entity instanceof Player _player)
					_player.closeContainer();
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("Inventorybackup");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new InventorybackupMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
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
			BackpackwriteitemProcedure.execute(world, x, y, z, entity);
		}
	}
}
