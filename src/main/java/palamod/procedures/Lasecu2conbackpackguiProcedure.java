package palamod.procedures;

import palamod.world.inventory.BackpacktitaneMenu;
import palamod.world.inventory.BackpackpaladiumMenu;
import palamod.world.inventory.BackpackendiumMenu;
import palamod.world.inventory.BackpackamethystguiMenu;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;
import java.util.Map;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Lasecu2conbackpackguiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double i2 = 0;
		double i = 0;
		File backpack_titane = new File("");
		File backpack_endium = new File("");
		File backpack = new File("");
		File backpack_paladium = new File("");
		File backpack_backup = new File("");
		com.google.gson.JsonObject main_backpack_ame = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_titane = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_pala = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_endium = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_backpack_backup = new com.google.gson.JsonObject();
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof BackpackamethystguiMenu && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_BACKPACK.get())
				|| entity instanceof Player _plr3 && _plr3.containerMenu instanceof BackpacktitaneMenu && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_BACKPACK.get())
				|| entity instanceof Player _plr6 && _plr6.containerMenu instanceof BackpackpaladiumMenu && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADUM_BACKPACK.get())
				|| entity instanceof Player _plr9 && _plr9.containerMenu instanceof BackpackendiumMenu && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_BACKPACK.get())) {
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
				if (entity instanceof Player _plr33 && _plr33.containerMenu instanceof BackpackamethystguiMenu
						&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_BACKPACK.get())) {
					i2 = 9;
				} else if (entity instanceof Player _plr36 && _plr36.containerMenu instanceof BackpacktitaneMenu
						&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_BACKPACK.get())) {
					i2 = 27;
				} else if (entity instanceof Player _plr39 && _plr39.containerMenu instanceof BackpackpaladiumMenu
						&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADUM_BACKPACK.get())) {
					i2 = 54;
				} else if (entity instanceof Player _plr42 && _plr42.containerMenu instanceof BackpackendiumMenu
						&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_BACKPACK.get())) {
					i2 = 81;
				}
				i = 0;
				if (i2 >= 0) {
					for (int index0 = 0; index0 < 9; index0++) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).copy();
							_setstack.setCount(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount((int) i));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get((int) i)).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
						i = i + 1;
					}
				}
				if (i2 >= 9) {
					for (int index1 = 0; index1 < 18; index1++) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).copy();
							_setstack.setCount(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount((int) i));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get((int) i)).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
						i = i + 1;
					}
				}
				if (i2 >= 27) {
					for (int index2 = 0; index2 < 18; index2++) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).copy();
							_setstack.setCount(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount((int) i));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get((int) i)).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
						i = i + 1;
					}
				}
				if (i2 >= 55) {
					for (int index3 = 0; index3 < 18; index3++) {
						i = i + 1;
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get((int) i)).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).copy();
							_setstack.setCount(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount((int) i));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				}
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(backpack_backup));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						main_backpack_ame = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						main_backpack_backup.addProperty("noSave", true);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(backpack_backup);
						fileWriter.write(mainGSONBuilderVariable.toJson(main_backpack_backup));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
		}
	}
}
