package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GuijobsminercheckcraftProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double lvl = 0;
		File jobs = new File("");
		boolean is_a_craft = false;
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "\\jobs\\" + entity.getUUID().toString()), File.separator + "jobs.json");
		if (jobs.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					lvl = main.get("lvl_miner").getAsDouble();
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0
									|| getAmountInGUISlot(entity, 9) < 64 && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.WITHEREDOBSIDIAN_0.get().asItem())
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.WITHER_ROSE.asItem()
							&& (75 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack29 = new ItemStack(PalamodModBlocks.WITHEREDOBSIDIAN_0.get()).copy();
							_setstack29.setCount(1);
							_menu.getSlots().get(9).set(_setstack29);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANEEXCAVATOR
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANEEXCAVATOR
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANEEXCAVATOR
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANEEXCAVATOR
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0
									|| getAmountInGUISlot(entity, 9) < 1 && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.GREENPALADUMEXCATOR.get())
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (70 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack53 = new ItemStack(PalamodModItems.GREENPALADUMEXCATOR.get()).copy();
							_setstack53.setCount(1);
							_menu.getSlots().get(9).set(_setstack53);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu58 ? _menu58.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu70 ? _menu70.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (100 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						is_a_craft = true;
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack78 = new ItemStack(PalamodModItems.ENDIUM_PICKAXE.get()).copy();
							_setstack78.setCount(1);
							_menu.getSlots().get(9).set(_setstack78);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu79 ? _menu79.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_PICKAXE.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_PICKAXE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_PICKAXE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu87 ? _menu87.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (1 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack95 = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_1.get()).copy();
							_setstack95.setCount(1);
							_menu.getSlots().get(9).set(_setstack95);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu98 ? _menu98.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.CHEST.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu102 ? _menu102.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu104 ? _menu104.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& getAmountInGUISlot(entity, 0) == 0 && getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.VOIDSTONE.get())
							&& (5 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						is_a_craft = true;
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack115 = new ItemStack(PalamodModItems.VOIDSTONE.get()).copy();
							_setstack115.setCount(1);
							_menu.getSlots().get(9).set(_setstack115);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu116 ? _menu116.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu118 ? _menu118.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.AMETHYST_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu120 ? _menu120.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.AMETHYST_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu122 ? _menu122.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu124 ? _menu124.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (5 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack132 = new ItemStack(PalamodModItems.AMETHYST_EXCAVATOR.get()).copy();
							_setstack132.setCount(1);
							_menu.getSlots().get(9).set(_setstack132);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu133 ? _menu133.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu135 ? _menu135.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_SHOVEL
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu137 ? _menu137.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_SHOVEL
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu139 ? _menu139.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu141 ? _menu141.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (45 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack149 = new ItemStack(PalamodModItems.TITANEEXCAVATOR.get()).copy();
							_setstack149.setCount(1);
							_menu.getSlots().get(9).set(_setstack149);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu152 ? _menu152.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUM_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu154 ? _menu154.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUM_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu156 ? _menu156.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu158 ? _menu158.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (67 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack166 = new ItemStack(PalamodModItems.PALADIUMEXCAVATOR.get()).copy();
							_setstack166.setCount(1);
							_menu.getSlots().get(9).set(_setstack166);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu167 ? _menu167.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUMGREENSHOVEL
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu169 ? _menu169.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUMGREENSHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu171 ? _menu171.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUMGREENSHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu173 ? _menu173.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu175 ? _menu175.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (79 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack183 = new ItemStack(PalamodModItems.GREENPALADUMEXCATOR.get()).copy();
							_setstack183.setCount(1);
							_menu.getSlots().get(9).set(_setstack183);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu184 ? _menu184.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu186 ? _menu186.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu188 ? _menu188.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu190 ? _menu190.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu192 ? _menu192.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& getAmountInGUISlot(entity, 0) == 0 && getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 7) == 0
							&& (15 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack199 = new ItemStack(PalamodModItems.MAGICAL_TOOL.get()).copy();
							_setstack199.setCount(1);
							_menu.getSlots().get(9).set(_setstack199);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu200 ? _menu200.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_SPIKE.get()
							.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu202 ? _menu202.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu204 ? _menu204.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_SPIKE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu206 ? _menu206.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu208 ? _menu208.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (15 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack216 = new ItemStack(PalamodModItems.OBSIDIANPICKAXE.get()).copy();
							_setstack216.setCount(1);
							_menu.getSlots().get(9).set(_setstack216);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu217 ? _menu217.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.RENFORCED_OBSIDIAN
							.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu219 ? _menu219.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.GUNPOWDER
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu230 ? _menu230.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.BOOM_OBSIDIAN.get().asItem())
							&& (15 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack233 = new ItemStack(PalamodModBlocks.BOOM_OBSIDIAN.get()).copy();
							_setstack233.setCount(1);
							_menu.getSlots().get(9).set(_setstack233);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu234 ? _menu234.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu236 ? _menu236.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu238 ? _menu238.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu240 ? _menu240.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu242 ? _menu242.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu244 ? _menu244.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu246 ? _menu246.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu248 ? _menu248.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu250 ? _menu250.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu254 ? _menu254.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.COMPACTED_OBSIDIAN.get().asItem())
							&& (15 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack257 = new ItemStack(PalamodModBlocks.COMPACTED_OBSIDIAN.get()).copy();
							_setstack257.setCount(1);
							_menu.getSlots().get(9).set(_setstack257);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu258 ? _menu258.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu260 ? _menu260.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu262 ? _menu262.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu264 ? _menu264.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu266 ? _menu266.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu268 ? _menu268.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu270 ? _menu270.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu272 ? _menu272.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu274 ? _menu274.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu278 ? _menu278.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.COMPACTED_OBSIDIAN.get().asItem())
							&& (22 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack281 = new ItemStack(PalamodModBlocks.COMPACTED_OBSIDIAN.get()).copy();
							_setstack281.setCount(4);
							_menu.getSlots().get(9).set(_setstack281);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu282 ? _menu282.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.GUNPOWDER
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu284 ? _menu284.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu286 ? _menu286.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu288 ? _menu288.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu290 ? _menu290.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& getAmountInGUISlot(entity, 0) == 0 && getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 5) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu297 ? _menu297.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.MEGABOOMOBSIDIAN.get().asItem())
							&& getAmountInGUISlot(entity, 7) == 0 && (23 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack301 = new ItemStack(PalamodModBlocks.MEGABOOMOBSIDIAN.get()).copy();
							_setstack301.setCount(1);
							_menu.getSlots().get(9).set(_setstack301);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu302 ? _menu302.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu304 ? _menu304.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.WOODEN_SPIKE
									.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu315 ? _menu315.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.WOODEN_OBSIDIAN_SPIKE.get().asItem())
							&& (27 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack318 = new ItemStack(PalamodModBlocks.WOODEN_OBSIDIAN_SPIKE.get()).copy();
							_setstack318.setCount(1);
							_menu.getSlots().get(9).set(_setstack318);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu319 ? _menu319.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu321 ? _menu321.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.IRON_SPIKE
									.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu332 ? _menu332.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.IRON_OBSIDIAN_SPIKE.get().asItem())
							&& (28 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack335 = new ItemStack(PalamodModBlocks.IRON_OBSIDIAN_SPIKE.get()).copy();
							_setstack335.setCount(1);
							_menu.getSlots().get(9).set(_setstack335);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu336 ? _menu336.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu338 ? _menu338.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.SPIKE_GOLD
									.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu349 ? _menu349.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.GOLDEN_OBSIDIAN_SPIKE.get().asItem())
							&& (29 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack352 = new ItemStack(PalamodModBlocks.GOLDEN_OBSIDIAN_SPIKE.get()).copy();
							_setstack352.setCount(1);
							_menu.getSlots().get(9).set(_setstack352);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu353 ? _menu353.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu355 ? _menu355.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.DIAMOND_SPIKE
									.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu366 ? _menu366.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.DIAMOND_OBSIDIAN_SPIKE.get().asItem())
							&& (30 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack369 = new ItemStack(PalamodModBlocks.DIAMOND_OBSIDIAN_SPIKE.get()).copy();
							_setstack369.setCount(1);
							_menu.getSlots().get(9).set(_setstack369);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu370 ? _menu370.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu372 ? _menu372.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.AMETHYST_SPIKE.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu383 ? _menu383.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.AMETHYS_TOBSIDIAN_SPIKE.get().asItem())
							&& (31 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack386 = new ItemStack(PalamodModBlocks.AMETHYS_TOBSIDIAN_SPIKE.get()).copy();
							_setstack386.setCount(1);
							_menu.getSlots().get(9).set(_setstack386);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu387 ? _menu387.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu389 ? _menu389.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.AMETHYST_SPIKE.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu400 ? _menu400.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.AMETHYS_TOBSIDIAN_SPIKE.get().asItem())
							&& (32 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack403 = new ItemStack(PalamodModBlocks.AMETHYS_TOBSIDIAN_SPIKE.get()).copy();
							_setstack403.setCount(1);
							_menu.getSlots().get(9).set(_setstack403);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu404 ? _menu404.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu406 ? _menu406.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.TITANE_SPIKE
									.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu417 ? _menu417.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.TITANE_OBSIDIAN_SPIKE.get().asItem())
							&& (33 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack420 = new ItemStack(PalamodModBlocks.TITANE_OBSIDIAN_SPIKE.get()).copy();
							_setstack420.setCount(1);
							_menu.getSlots().get(9).set(_setstack420);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu421 ? _menu421.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu423 ? _menu423.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu425 ? _menu425.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu427 ? _menu427.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu429 ? _menu429.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu431 ? _menu431.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu433 ? _menu433.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu435 ? _menu435.getSlots().get(7).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu437 ? _menu437.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu441 ? _menu441.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.GODVILLAGER_SPAWN_EGG.get())
							&& (95 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack444 = new ItemStack(PalamodModItems.GODVILLAGER_SPAWN_EGG.get()).copy();
							_setstack444.setCount(1);
							_menu.getSlots().get(9).set(_setstack444);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu445 ? _menu445.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.BRICKS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu447 ? _menu447.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_FURNACE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu449 ? _menu449.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.BRICKS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu451 ? _menu451.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_FURNACE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu453 ? _menu453.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.FINDIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu455 ? _menu455.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_FURNACE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu457 ? _menu457.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.BRICKS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu459 ? _menu459.getSlots().get(7).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_FURNACE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu461 ? _menu461.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.BRICKS.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu465 ? _menu465.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.PALADIUM_FORGE.get().asItem())
							&& (56 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack468 = new ItemStack(PalamodModBlocks.PALADIUM_FORGE.get()).copy();
							_setstack468.setCount(3);
							_menu.getSlots().get(9).set(_setstack468);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if (getAmountInGUISlot(entity, 1) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu470 ? _menu470.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu472 ? _menu472.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu474 ? _menu474.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu476 ? _menu476.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& getAmountInGUISlot(entity, 0) == 0 && getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 5) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu483 ? _menu483.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.SEALEDXPBOTTLE.get())
							&& getAmountInGUISlot(entity, 9) == 0 && (50 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack487 = new ItemStack(PalamodModItems.SEALEDXPBOTTLE.get()).copy();
							_setstack487.setCount(1);
							_menu.getSlots().get(9).set(_setstack487);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu488 ? _menu488.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu490 ? _menu490.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu492 ? _menu492.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu494 ? _menu494.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.VOIDSTONE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu496 ? _menu496.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
							&& getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 5) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu500 ? _menu500.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu502 ? _menu502.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu506 ? _menu506.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.DOLLARS_STONE.get())
							&& getAmountInGUISlot(entity, 9) == 0 && (37 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack510 = new ItemStack(PalamodModItems.DOLLARS_STONE.get()).copy();
							_setstack510.setCount(1);
							_menu.getSlots().get(9).set(_setstack510);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu511 ? _menu511.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu513 ? _menu513.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu515 ? _menu515.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.VOIDSTONE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu517 ? _menu517.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu519 ? _menu519.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.TITANE_CHEST
									.get().asItem()
							&& getAmountInGUISlot(entity, 0) == 0 && getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu526 ? _menu526.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.MINAGE_VOIDSTONE.get())
							&& getAmountInGUISlot(entity, 9) == 0 && (30 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack530 = new ItemStack(PalamodModItems.MINAGE_VOIDSTONE.get()).copy();
							_setstack530.setCount(1);
							_menu.getSlots().get(9).set(_setstack530);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu531 ? _menu531.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& getAmountInGUISlot(entity, 1) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu534 ? _menu534.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu536 ? _menu536.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu538 ? _menu538.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu540 ? _menu540.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu542 ? _menu542.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& getAmountInGUISlot(entity, 7) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu545 ? _menu545.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu549 ? _menu549.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.COBBLEBREAKER_PALADIUM_UPGRADE.get())
							&& (70 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack552 = new ItemStack(PalamodModItems.COBBLEBREAKER_PALADIUM_UPGRADE.get()).copy();
							_setstack552.setCount(1);
							_menu.getSlots().get(9).set(_setstack552);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu553 ? _menu553.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT.get()
							&& getAmountInGUISlot(entity, 1) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu556 ? _menu556.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu558 ? _menu558.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu560 ? _menu560.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COBBLEBREAKER_AMETHYST_UPGRADE.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu562 ? _menu562.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu564 ? _menu564.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& getAmountInGUISlot(entity, 7) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu567 ? _menu567.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu571 ? _menu571.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get())
							&& (55 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack574 = new ItemStack(PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get()).copy();
							_setstack574.setCount(1);
							_menu.getSlots().get(9).set(_setstack574);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu575 ? _menu575.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu577 ? _menu577.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.COBBLEBREAKER
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu579 ? _menu579.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu581 ? _menu581.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& getAmountInGUISlot(entity, 4) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu584 ? _menu584.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu586 ? _menu586.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu588 ? _menu588.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.SPEED_MODIFIER
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu590 ? _menu590.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu594 ? _menu594.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.COBBLEBREAKER_AMETHYST_UPGRADE.get())
							&& (40 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack597 = new ItemStack(PalamodModItems.COBBLEBREAKER_AMETHYST_UPGRADE.get()).copy();
							_setstack597.setCount(1);
							_menu.getSlots().get(9).set(_setstack597);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu598 ? _menu598.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& getAmountInGUISlot(entity, 1) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu601 ? _menu601.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu603 ? _menu603.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu605 ? _menu605.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.VOIDSTONE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu607 ? _menu607.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu609 ? _menu609.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu611 ? _menu611.getSlots().get(7).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.FORTUNE_MODIFIER.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu613 ? _menu613.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu617 ? _menu617.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.COBBLEBREAKER.get().asItem())
							&& (25 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack620 = new ItemStack(PalamodModBlocks.COBBLEBREAKER.get()).copy();
							_setstack620.setCount(1);
							_menu.getSlots().get(9).set(_setstack620);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu621 ? _menu621.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu623 ? _menu623.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu625 ? _menu625.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu627 ? _menu627.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu629 ? _menu629.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu631 ? _menu631.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu633 ? _menu633.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu635 ? _menu635.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu637 ? _menu637.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu641 ? _menu641.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.ENDIUMTNT.get().asItem())
							&& (100 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack644 = new ItemStack(PalamodModBlocks.ENDIUMTNT.get()).copy();
							_setstack644.setCount(4);
							_menu.getSlots().get(9).set(_setstack644);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu645 ? _menu645.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu647 ? _menu647.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu649 ? _menu649.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu651 ? _menu651.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.COMPRESSEDSPONGE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu653 ? _menu653.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.BUCKET
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu655 ? _menu655.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.COMPRESSEDSPONGE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu657 ? _menu657.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu659 ? _menu659.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu661 ? _menu661.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu665 ? _menu665.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.SPONGETNT.get().asItem())
							&& (74 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack668 = new ItemStack(PalamodModBlocks.SPONGETNT.get()).copy();
							_setstack668.setCount(2);
							_menu.getSlots().get(9).set(_setstack668);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu669 ? _menu669.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.WITHER_SKELETON_SKULL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu671 ? _menu671.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.WITHER_SKELETON_SKULL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu673 ? _menu673.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.WITHER_SKELETON_SKULL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu675 ? _menu675.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu677 ? _menu677.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu679 ? _menu679.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.COMPACTTNT
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu681 ? _menu681.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu683 ? _menu683.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu685 ? _menu685.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu689 ? _menu689.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.WITHERTNT.get().asItem())
							&& (48 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack692 = new ItemStack(PalamodModBlocks.WITHERTNT.get()).copy();
							_setstack692.setCount(1);
							_menu.getSlots().get(9).set(_setstack692);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu693 ? _menu693.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu695 ? _menu695.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu697 ? _menu697.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu699 ? _menu699.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.SPLASH_POTION
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu701 ? _menu701.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu703 ? _menu703.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Items.SPLASH_POTION
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu705 ? _menu705.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu707 ? _menu707.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu709 ? _menu709.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu713 ? _menu713.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.COMPACTTNT.get().asItem())
							&& (25 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack716 = new ItemStack(PalamodModBlocks.MAGIC_TNT.get()).copy();
							_setstack716.setCount(2);
							_menu.getSlots().get(9).set(_setstack716);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu717 ? _menu717.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu719 ? _menu719.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu721 ? _menu721.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu723 ? _menu723.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu725 ? _menu725.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu727 ? _menu727.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu729 ? _menu729.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu731 ? _menu731.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu733 ? _menu733.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu737 ? _menu737.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.COMPACTTNT.get().asItem())
							&& (18 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack740 = new ItemStack(PalamodModBlocks.COMPACTTNT.get()).copy();
							_setstack740.setCount(3);
							_menu.getSlots().get(9).set(_setstack740);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu741 ? _menu741.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu743 ? _menu743.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu745 ? _menu745.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu747 ? _menu747.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu749 ? _menu749.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.FINDIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu751 ? _menu751.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu753 ? _menu753.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu755 ? _menu755.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu757 ? _menu757.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu761 ? _menu761.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.CAVE_BLOCK.get().asItem())
							&& (10 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack764 = new ItemStack(PalamodModBlocks.CAVE_BLOCK.get()).copy();
							_setstack764.setCount(1);
							_menu.getSlots().get(9).set(_setstack764);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu765 ? _menu765.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu767 ? _menu767.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu769 ? _menu769.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu771 ? _menu771.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu773 ? _menu773.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.FINDIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu775 ? _menu775.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu777 ? _menu777.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu779 ? _menu779.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu781 ? _menu781.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu785 ? _menu785.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.CAVE_BLOCK.get().asItem())
							&& (10 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack788 = new ItemStack(PalamodModBlocks.CAVE_BLOCK.get()).copy();
							_setstack788.setCount(1);
							_menu.getSlots().get(9).set(_setstack788);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu789 ? _menu789.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu791 ? _menu791.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu793 ? _menu793.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu795 ? _menu795.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu797 ? _menu797.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.SPLASH_POTION
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu799 ? _menu799.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu801 ? _menu801.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu803 ? _menu803.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu805 ? _menu805.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu809 ? _menu809.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.POISON_OBSIDIAN.get().asItem())
							&& (22 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack812 = new ItemStack(PalamodModBlocks.POISON_OBSIDIAN.get()).copy();
							_setstack812.setCount(8);
							_menu.getSlots().get(9).set(_setstack812);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu813 ? _menu813.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu815 ? _menu815.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu817 ? _menu817.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu819 ? _menu819.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.SLIMEPAD
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu821 ? _menu821.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.SLIMEPAD
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu823 ? _menu823.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.SLIMEPAD
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu825 ? _menu825.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu827 ? _menu827.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu829 ? _menu829.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu833 ? _menu833.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.SLIME_OBSIDIAN.get().asItem())
							&& (22 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack836 = new ItemStack(PalamodModBlocks.SLIME_OBSIDIAN.get()).copy();
							_setstack836.setCount(2);
							_menu.getSlots().get(9).set(_setstack836);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu837 ? _menu837.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.FAKE_WATER_BUCKET
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu839 ? _menu839.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu850 ? _menu850.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.FAKE_WATER_OBSIDIAN.get().asItem())
							&& (42 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack854 = new ItemStack(Items.BUCKET).copy();
							_setstack854.setCount(getAmountInGUISlot(entity, 0) + 1);
							_menu.getSlots().get(0).set(_setstack854);
							ItemStack _setstack856 = new ItemStack(PalamodModBlocks.FAKE_WATER_OBSIDIAN.get()).copy();
							_setstack856.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack856);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu857 ? _menu857.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu859 ? _menu859.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0 && (39 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack870 = new ItemStack(Items.BUCKET).copy();
							_setstack870.setCount(getAmountInGUISlot(entity, 0) + 1);
							_menu.getSlots().get(0).set(_setstack870);
							ItemStack _setstack872 = new ItemStack(PalamodModBlocks.LAVA_OBSIDIAN.get()).copy();
							_setstack872.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack872);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu873 ? _menu873.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu875 ? _menu875.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_SPIKE.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu886 ? _menu886.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.PALADIUM_OBSIDIAN_SPIKE.get().asItem())
							&& (34 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack889 = new ItemStack(PalamodModBlocks.PALADIUM_OBSIDIAN_SPIKE.get()).copy();
							_setstack889.setCount(1);
							_menu.getSlots().get(9).set(_setstack889);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if (!is_a_craft) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(9).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
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