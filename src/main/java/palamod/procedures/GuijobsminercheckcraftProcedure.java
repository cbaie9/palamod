package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

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
		jobs = GetjobsfileProcedure.execute(entity);
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
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0
									|| getAmountInGUISlot(entity, 9) < 64 && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.WITHERED_OBSIDIAN_0.get().asItem())
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.WITHER_ROSE.asItem()
							&& (75 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack25 = new ItemStack(PalamodModBlocks.WITHERED_OBSIDIAN_0.get()).copy();
							_setstack25.setCount(1);
							_menu.getSlots().get(9).set(_setstack25);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_EXCAVATOR
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_EXCAVATOR
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_EXCAVATOR
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_EXCAVATOR
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0
									|| getAmountInGUISlot(entity, 9) < 1 && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.GREEN_PALADUM_EXCAVATOR.get())
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (70 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack49 = new ItemStack(PalamodModItems.GREEN_PALADUM_EXCAVATOR.get()).copy();
							_setstack49.setCount(1);
							_menu.getSlots().get(9).set(_setstack49);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu52 ? _menu52.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu58 ? _menu58.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (100 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						is_a_craft = true;
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack74 = new ItemStack(PalamodModItems.ENDIUM_PICKAXE.get()).copy();
							_setstack74.setCount(1);
							_menu.getSlots().get(9).set(_setstack74);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu75 ? _menu75.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_PICKAXE.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu77 ? _menu77.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_PICKAXE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu79 ? _menu79.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_PICKAXE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (1 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack91 = new ItemStack(PalamodModItems.PICKAXE_OF_THE_GODS_LV1.get()).copy();
							_setstack91.setCount(1);
							_menu.getSlots().get(9).set(_setstack91);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu92 ? _menu92.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu94 ? _menu94.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.CHEST.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu98 ? _menu98.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& getAmountInGUISlot(entity, 0) == 0 && getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu108 ? _menu108.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.VOIDSTONE.get())
							&& (5 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						is_a_craft = true;
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack111 = new ItemStack(PalamodModItems.VOIDSTONE.get()).copy();
							_setstack111.setCount(1);
							_menu.getSlots().get(9).set(_setstack111);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu114 ? _menu114.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.AMETHYST_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu116 ? _menu116.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.AMETHYST_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu118 ? _menu118.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu120 ? _menu120.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (5 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack128 = new ItemStack(PalamodModItems.AMETHYST_EXCAVATOR.get()).copy();
							_setstack128.setCount(1);
							_menu.getSlots().get(9).set(_setstack128);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu129 ? _menu129.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu131 ? _menu131.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_SHOVEL
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu133 ? _menu133.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_SHOVEL
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu135 ? _menu135.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu137 ? _menu137.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (45 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack145 = new ItemStack(PalamodModItems.TITANE_EXCAVATOR.get()).copy();
							_setstack145.setCount(1);
							_menu.getSlots().get(9).set(_setstack145);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu146 ? _menu146.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu148 ? _menu148.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUM_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUM_SHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu152 ? _menu152.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu154 ? _menu154.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (67 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack162 = new ItemStack(PalamodModItems.PALADIUM_EXCAVATOR.get()).copy();
							_setstack162.setCount(1);
							_menu.getSlots().get(9).set(_setstack162);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu163 ? _menu163.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUMGREENSHOVEL
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu165 ? _menu165.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUMGREENSHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu167 ? _menu167.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUMGREENSHOVEL.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu169 ? _menu169.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu171 ? _menu171.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (79 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack179 = new ItemStack(PalamodModItems.GREEN_PALADUM_EXCAVATOR.get()).copy();
							_setstack179.setCount(1);
							_menu.getSlots().get(9).set(_setstack179);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu180 ? _menu180.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu182 ? _menu182.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu184 ? _menu184.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu186 ? _menu186.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu188 ? _menu188.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& getAmountInGUISlot(entity, 0) == 0 && getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 7) == 0
							&& (15 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack195 = new ItemStack(PalamodModItems.MAGICAL_TOOL.get()).copy();
							_setstack195.setCount(1);
							_menu.getSlots().get(9).set(_setstack195);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu196 ? _menu196.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_SPIKE.get()
							.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu198 ? _menu198.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu200 ? _menu200.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_SPIKE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu202 ? _menu202.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu204 ? _menu204.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (15 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack212 = new ItemStack(PalamodModItems.OBSIDIAN_PICKAXE.get()).copy();
							_setstack212.setCount(1);
							_menu.getSlots().get(9).set(_setstack212);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu213 ? _menu213.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.RENFORCED_OBSIDIAN
							.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu215 ? _menu215.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.GUNPOWDER
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu226 ? _menu226.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.BOOM_OBSIDIAN.get().asItem())
							&& (15 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack229 = new ItemStack(PalamodModBlocks.BOOM_OBSIDIAN.get()).copy();
							_setstack229.setCount(1);
							_menu.getSlots().get(9).set(_setstack229);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu230 ? _menu230.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu232 ? _menu232.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu234 ? _menu234.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu236 ? _menu236.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu238 ? _menu238.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu240 ? _menu240.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu242 ? _menu242.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu244 ? _menu244.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu246 ? _menu246.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu250 ? _menu250.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.COMPACTED_OBSIDIAN.get().asItem())
							&& (15 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack253 = new ItemStack(PalamodModBlocks.COMPACTED_OBSIDIAN.get()).copy();
							_setstack253.setCount(1);
							_menu.getSlots().get(9).set(_setstack253);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu254 ? _menu254.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu256 ? _menu256.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu258 ? _menu258.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu260 ? _menu260.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu262 ? _menu262.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu264 ? _menu264.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu266 ? _menu266.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu268 ? _menu268.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu270 ? _menu270.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu274 ? _menu274.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.COMPACTED_OBSIDIAN.get().asItem())
							&& (22 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack277 = new ItemStack(PalamodModBlocks.COMPACTED_OBSIDIAN.get()).copy();
							_setstack277.setCount(4);
							_menu.getSlots().get(9).set(_setstack277);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu278 ? _menu278.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.GUNPOWDER
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu280 ? _menu280.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu282 ? _menu282.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu284 ? _menu284.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu286 ? _menu286.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& getAmountInGUISlot(entity, 0) == 0 && getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 5) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu293 ? _menu293.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.MEGABOOMOBSIDIAN.get().asItem())
							&& getAmountInGUISlot(entity, 7) == 0 && (23 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack297 = new ItemStack(PalamodModBlocks.MEGABOOMOBSIDIAN.get()).copy();
							_setstack297.setCount(1);
							_menu.getSlots().get(9).set(_setstack297);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu298 ? _menu298.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu300 ? _menu300.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.WOODEN_SPIKE
									.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu311 ? _menu311.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.WOODEN_OBSIDIAN_SPIKE.get().asItem())
							&& (27 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack314 = new ItemStack(PalamodModBlocks.WOODEN_OBSIDIAN_SPIKE.get()).copy();
							_setstack314.setCount(1);
							_menu.getSlots().get(9).set(_setstack314);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu315 ? _menu315.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu317 ? _menu317.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.IRON_SPIKE
									.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu328 ? _menu328.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.IRON_OBSIDIAN_SPIKE.get().asItem())
							&& (28 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack331 = new ItemStack(PalamodModBlocks.IRON_OBSIDIAN_SPIKE.get()).copy();
							_setstack331.setCount(1);
							_menu.getSlots().get(9).set(_setstack331);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu332 ? _menu332.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu334 ? _menu334.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.SPIKE_GOLD
									.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu345 ? _menu345.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.GOLDEN_OBSIDIAN_SPIKE.get().asItem())
							&& (29 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack348 = new ItemStack(PalamodModBlocks.GOLDEN_OBSIDIAN_SPIKE.get()).copy();
							_setstack348.setCount(1);
							_menu.getSlots().get(9).set(_setstack348);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu349 ? _menu349.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu351 ? _menu351.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.DIAMOND_SPIKE
									.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu362 ? _menu362.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.DIAMOND_OBSIDIAN_SPIKE.get().asItem())
							&& (30 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack365 = new ItemStack(PalamodModBlocks.DIAMOND_OBSIDIAN_SPIKE.get()).copy();
							_setstack365.setCount(1);
							_menu.getSlots().get(9).set(_setstack365);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu366 ? _menu366.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu368 ? _menu368.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.AMETHYST_SPIKE.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu379 ? _menu379.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.AMETHYST_OBSIDIAN_SPIKE.get().asItem())
							&& (31 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack382 = new ItemStack(PalamodModBlocks.AMETHYST_OBSIDIAN_SPIKE.get()).copy();
							_setstack382.setCount(1);
							_menu.getSlots().get(9).set(_setstack382);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu383 ? _menu383.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu385 ? _menu385.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.AMETHYST_SPIKE.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu396 ? _menu396.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.AMETHYST_OBSIDIAN_SPIKE.get().asItem())
							&& (32 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack399 = new ItemStack(PalamodModBlocks.AMETHYST_OBSIDIAN_SPIKE.get()).copy();
							_setstack399.setCount(1);
							_menu.getSlots().get(9).set(_setstack399);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu400 ? _menu400.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu402 ? _menu402.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.TITANE_SPIKE
									.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu413 ? _menu413.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.TITANE_OBSIDIAN_SPIKE.get().asItem())
							&& (33 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack416 = new ItemStack(PalamodModBlocks.TITANE_OBSIDIAN_SPIKE.get()).copy();
							_setstack416.setCount(1);
							_menu.getSlots().get(9).set(_setstack416);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu417 ? _menu417.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu419 ? _menu419.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu421 ? _menu421.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu423 ? _menu423.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu425 ? _menu425.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu427 ? _menu427.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu429 ? _menu429.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu431 ? _menu431.getSlots().get(7).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu433 ? _menu433.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu437 ? _menu437.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.GODVILLAGER_SPAWN_EGG.get())
							&& (95 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack440 = new ItemStack(PalamodModItems.GODVILLAGER_SPAWN_EGG.get()).copy();
							_setstack440.setCount(1);
							_menu.getSlots().get(9).set(_setstack440);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu441 ? _menu441.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.BRICKS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu443 ? _menu443.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_FURNACE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu445 ? _menu445.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.BRICKS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu447 ? _menu447.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_FURNACE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu449 ? _menu449.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.FINDIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu451 ? _menu451.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_FURNACE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu453 ? _menu453.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.BRICKS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu455 ? _menu455.getSlots().get(7).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_FURNACE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu457 ? _menu457.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.BRICKS.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu461 ? _menu461.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.PALADIUM_FORGE.get().asItem())
							&& (56 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack464 = new ItemStack(PalamodModBlocks.PALADIUM_FORGE.get()).copy();
							_setstack464.setCount(3);
							_menu.getSlots().get(9).set(_setstack464);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if (getAmountInGUISlot(entity, 1) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu466 ? _menu466.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu468 ? _menu468.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu470 ? _menu470.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu472 ? _menu472.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& getAmountInGUISlot(entity, 0) == 0 && getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 5) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu479 ? _menu479.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.SEALEDXPBOTTLE.get())
							&& getAmountInGUISlot(entity, 9) == 0 && (50 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack483 = new ItemStack(PalamodModItems.SEALEDXPBOTTLE.get()).copy();
							_setstack483.setCount(1);
							_menu.getSlots().get(9).set(_setstack483);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu484 ? _menu484.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu486 ? _menu486.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu488 ? _menu488.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu490 ? _menu490.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.VOIDSTONE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu492 ? _menu492.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
							&& getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 5) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu496 ? _menu496.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu498 ? _menu498.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu502 ? _menu502.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.DOLLARS_STONE.get())
							&& getAmountInGUISlot(entity, 9) == 0 && (37 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack506 = new ItemStack(PalamodModItems.DOLLARS_STONE.get()).copy();
							_setstack506.setCount(1);
							_menu.getSlots().get(9).set(_setstack506);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu507 ? _menu507.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.ENDER_PEARL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu509 ? _menu509.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu511 ? _menu511.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.VOIDSTONE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu513 ? _menu513.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu515 ? _menu515.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.TITANE_CHEST
									.get().asItem()
							&& getAmountInGUISlot(entity, 0) == 0 && getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu522 ? _menu522.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.MINAGE_VOIDSTONE.get())
							&& getAmountInGUISlot(entity, 9) == 0 && (30 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack526 = new ItemStack(PalamodModItems.MINAGE_VOIDSTONE.get()).copy();
							_setstack526.setCount(1);
							_menu.getSlots().get(9).set(_setstack526);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu527 ? _menu527.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& getAmountInGUISlot(entity, 1) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu530 ? _menu530.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu532 ? _menu532.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu534 ? _menu534.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu536 ? _menu536.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu538 ? _menu538.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& getAmountInGUISlot(entity, 7) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu541 ? _menu541.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu545 ? _menu545.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.COBBLEBREAKER_PALADIUM_UPGRADE.get())
							&& (70 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack548 = new ItemStack(PalamodModItems.COBBLEBREAKER_PALADIUM_UPGRADE.get()).copy();
							_setstack548.setCount(1);
							_menu.getSlots().get(9).set(_setstack548);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu549 ? _menu549.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT.get()
							&& getAmountInGUISlot(entity, 1) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu552 ? _menu552.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu554 ? _menu554.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu556 ? _menu556.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COBBLEBREAKER_AMETHYST_UPGRADE.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu558 ? _menu558.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu560 ? _menu560.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& getAmountInGUISlot(entity, 7) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu563 ? _menu563.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu567 ? _menu567.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get())
							&& (55 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack570 = new ItemStack(PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get()).copy();
							_setstack570.setCount(1);
							_menu.getSlots().get(9).set(_setstack570);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu571 ? _menu571.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu573 ? _menu573.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.COBBLEBREAKER
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu575 ? _menu575.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu577 ? _menu577.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& getAmountInGUISlot(entity, 4) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu580 ? _menu580.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu582 ? _menu582.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu584 ? _menu584.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.SPEED_MODIFIER
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu586 ? _menu586.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu590 ? _menu590.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.COBBLEBREAKER_AMETHYST_UPGRADE.get())
							&& (40 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack593 = new ItemStack(PalamodModItems.COBBLEBREAKER_AMETHYST_UPGRADE.get()).copy();
							_setstack593.setCount(1);
							_menu.getSlots().get(9).set(_setstack593);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu594 ? _menu594.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& getAmountInGUISlot(entity, 1) == 0
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu597 ? _menu597.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu599 ? _menu599.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu601 ? _menu601.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.VOIDSTONE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu603 ? _menu603.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu605 ? _menu605.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu607 ? _menu607.getSlots().get(7).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.FORTUNE_MODIFIER.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu609 ? _menu609.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("neoforge:cobblestone")))
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu613 ? _menu613.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.COBBLEBREAKER.get().asItem())
							&& (25 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack616 = new ItemStack(PalamodModBlocks.COBBLEBREAKER.get()).copy();
							_setstack616.setCount(1);
							_menu.getSlots().get(9).set(_setstack616);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu617 ? _menu617.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu619 ? _menu619.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu621 ? _menu621.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu623 ? _menu623.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu625 ? _menu625.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu627 ? _menu627.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu629 ? _menu629.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu631 ? _menu631.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu633 ? _menu633.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu637 ? _menu637.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.TNT_ENDIUM.get().asItem())
							&& (100 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack640 = new ItemStack(PalamodModBlocks.TNT_ENDIUM.get()).copy();
							_setstack640.setCount(4);
							_menu.getSlots().get(9).set(_setstack640);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu641 ? _menu641.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu643 ? _menu643.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu645 ? _menu645.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu647 ? _menu647.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.COMPRESSED_SPONGE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu649 ? _menu649.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.BUCKET
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu651 ? _menu651.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.COMPRESSED_SPONGE.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu653 ? _menu653.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu655 ? _menu655.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu657 ? _menu657.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu661 ? _menu661.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.TNT_SPONGE.get().asItem())
							&& (74 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack664 = new ItemStack(PalamodModBlocks.TNT_SPONGE.get()).copy();
							_setstack664.setCount(2);
							_menu.getSlots().get(9).set(_setstack664);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu665 ? _menu665.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.WITHER_SKELETON_SKULL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu667 ? _menu667.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.WITHER_SKELETON_SKULL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu669 ? _menu669.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.WITHER_SKELETON_SKULL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu671 ? _menu671.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu673 ? _menu673.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu675 ? _menu675.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.TNT_COMPACT
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu677 ? _menu677.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu679 ? _menu679.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu681 ? _menu681.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu685 ? _menu685.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.TNT_WITHER.get().asItem())
							&& (48 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack688 = new ItemStack(PalamodModBlocks.TNT_WITHER.get()).copy();
							_setstack688.setCount(1);
							_menu.getSlots().get(9).set(_setstack688);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu689 ? _menu689.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu691 ? _menu691.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu693 ? _menu693.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu695 ? _menu695.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.SPLASH_POTION
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu697 ? _menu697.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu699 ? _menu699.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Items.SPLASH_POTION
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu701 ? _menu701.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu703 ? _menu703.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu705 ? _menu705.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu709 ? _menu709.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.TNT_COMPACT.get().asItem())
							&& (25 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack712 = new ItemStack(PalamodModBlocks.TNT_MAGIC.get()).copy();
							_setstack712.setCount(2);
							_menu.getSlots().get(9).set(_setstack712);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu713 ? _menu713.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu715 ? _menu715.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu717 ? _menu717.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu719 ? _menu719.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu721 ? _menu721.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu723 ? _menu723.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu725 ? _menu725.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu727 ? _menu727.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu729 ? _menu729.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.TNT.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu733 ? _menu733.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.TNT_COMPACT.get().asItem())
							&& (18 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack736 = new ItemStack(PalamodModBlocks.TNT_COMPACT.get()).copy();
							_setstack736.setCount(3);
							_menu.getSlots().get(9).set(_setstack736);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu737 ? _menu737.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu739 ? _menu739.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu741 ? _menu741.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu743 ? _menu743.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu745 ? _menu745.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.FINDIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu747 ? _menu747.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu749 ? _menu749.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu751 ? _menu751.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu753 ? _menu753.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu757 ? _menu757.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.CAVE_BLOCK.get().asItem())
							&& (10 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack760 = new ItemStack(PalamodModBlocks.CAVE_BLOCK.get()).copy();
							_setstack760.setCount(1);
							_menu.getSlots().get(9).set(_setstack760);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu761 ? _menu761.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu763 ? _menu763.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu765 ? _menu765.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu767 ? _menu767.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu769 ? _menu769.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.FINDIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu771 ? _menu771.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu773 ? _menu773.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu775 ? _menu775.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu777 ? _menu777.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.GLASS.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu781 ? _menu781.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.CAVE_BLOCK.get().asItem())
							&& (10 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack784 = new ItemStack(PalamodModBlocks.CAVE_BLOCK.get()).copy();
							_setstack784.setCount(1);
							_menu.getSlots().get(9).set(_setstack784);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu785 ? _menu785.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu787 ? _menu787.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu789 ? _menu789.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu791 ? _menu791.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu793 ? _menu793.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.SPLASH_POTION
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu795 ? _menu795.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu797 ? _menu797.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu799 ? _menu799.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu801 ? _menu801.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu805 ? _menu805.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.POISON_OBSIDIAN.get().asItem())
							&& (22 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack808 = new ItemStack(PalamodModBlocks.POISON_OBSIDIAN.get()).copy();
							_setstack808.setCount(8);
							_menu.getSlots().get(9).set(_setstack808);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu809 ? _menu809.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu811 ? _menu811.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu813 ? _menu813.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu815 ? _menu815.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.SLIMEPAD
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu817 ? _menu817.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.SLIMEPAD
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu819 ? _menu819.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.SLIMEPAD
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu821 ? _menu821.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu823 ? _menu823.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu825 ? _menu825.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu829 ? _menu829.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.SLIME_OBSIDIAN.get().asItem())
							&& (22 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack832 = new ItemStack(PalamodModBlocks.SLIME_OBSIDIAN.get()).copy();
							_setstack832.setCount(2);
							_menu.getSlots().get(9).set(_setstack832);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu833 ? _menu833.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.FAKE_WATER_BUCKET
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu835 ? _menu835.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu846 ? _menu846.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.FAKE_WATER_OBSIDIAN.get().asItem())
							&& (42 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack850 = new ItemStack(Items.BUCKET).copy();
							_setstack850.setCount(getAmountInGUISlot(entity, 0) + 1);
							_menu.getSlots().get(0).set(_setstack850);
							ItemStack _setstack852 = new ItemStack(PalamodModBlocks.FAKE_WATER_OBSIDIAN.get()).copy();
							_setstack852.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack852);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu853 ? _menu853.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu855 ? _menu855.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0 && (39 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack866 = new ItemStack(Items.BUCKET).copy();
							_setstack866.setCount(getAmountInGUISlot(entity, 0) + 1);
							_menu.getSlots().get(0).set(_setstack866);
							ItemStack _setstack868 = new ItemStack(PalamodModBlocks.LAVA_OBSIDIAN.get()).copy();
							_setstack868.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack868);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu869 ? _menu869.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu871 ? _menu871.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_SPIKE.get().asItem()
							&& getAmountInGUISlot(entity, 2) == 0 && getAmountInGUISlot(entity, 3) == 0 && getAmountInGUISlot(entity, 4) == 0 && getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0
							&& getAmountInGUISlot(entity, 7) == 0 && getAmountInGUISlot(entity, 8) == 0
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu882 ? _menu882.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.PALADIUM_OBSIDIAN_SPIKE.get().asItem())
							&& (34 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDCRAFT))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack885 = new ItemStack(PalamodModBlocks.PALADIUM_OBSIDIAN_SPIKE.get()).copy();
							_setstack885.setCount(1);
							_menu.getSlots().get(9).set(_setstack885);
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