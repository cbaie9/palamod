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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GuijobsfarmcheckcraftProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
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
					lvl = main.get("lvl_farmer").getAsDouble();
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (100 <= lvl || !(world instanceof ServerLevel _serverLevelGR15 && _serverLevelGR15.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack16 = new ItemStack(PalamodModItems.ENDIUM_HOE.get()).copy();
							_setstack16.setCount(1);
							_menu.getSlots().get(9).set(_setstack16);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (75 <= lvl || !(world instanceof ServerLevel _serverLevelGR30 && _serverLevelGR30.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack31 = new ItemStack(PalamodModItems.GREEN_PALADIUM_HOE.get()).copy();
							_setstack31.setCount(1);
							_menu.getSlots().get(9).set(_setstack31);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(Identifier.parse("minecraft:logs")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.CREEPER_HEAD.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(Identifier.parse("minecraft:logs")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(Identifier.parse("minecraft:logs")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(Identifier.parse("minecraft:logs")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.BONE_MEAL
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(Identifier.parse("minecraft:logs")))
							&& getAmountInGUISlot(entity, 9) == 0 && (55 <= lvl || !(world instanceof ServerLevel _serverLevelGR51 && _serverLevelGR51.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack52 = new ItemStack(PalamodModBlocks.TOTEM_FERTILITY.get()).copy();
							_setstack52.setCount(1);
							_menu.getSlots().get(9).set(_setstack52);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu53 ? _menu53.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu55 ? _menu55.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu61 ? _menu61.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu67 ? _menu67.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (100 <= lvl || !(world instanceof ServerLevel _serverLevelGR71 && _serverLevelGR71.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack72 = new ItemStack(PalamodModItems.ENDIUM_AXE.get()).copy();
							_setstack72.setCount(1);
							_menu.getSlots().get(9).set(_setstack72);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu73 ? _menu73.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu75 ? _menu75.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu77 ? _menu77.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu79 ? _menu79.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu87 ? _menu87.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu89 ? _menu89.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& getAmountInGUISlot(entity, 9) == 0 && (100 <= lvl || !(world instanceof ServerLevel _serverLevelGR92 && _serverLevelGR92.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack93 = new ItemStack(PalamodModItems.ENDIUM_ARMOR_CHESTPLATE.get()).copy();
							_setstack93.setCount(1);
							_menu.getSlots().get(9).set(_setstack93);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu94 ? _menu94.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COMPRESSED_AMETHYST.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu98 ? _menu98.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu102 ? _menu102.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.FINDIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu104 ? _menu104.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu108 ? _menu108.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu110 ? _menu110.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_CORE
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 64
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu114 ? _menu114.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.PALADIUM_CRUSHER.get().asItem())
							&& (40 <= lvl || !(world instanceof ServerLevel _serverLevelGR116 && _serverLevelGR116.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack117 = new ItemStack(PalamodModBlocks.PALADIUM_CRUSHER.get()).copy();
							_setstack117.setCount(1);
							_menu.getSlots().get(9).set(_setstack117);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu118 ? _menu118.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu120 ? _menu120.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_CHEST.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu122 ? _menu122.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu124 ? _menu124.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu126 ? _menu126.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.HOPPER.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu128 ? _menu128.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu130 ? _menu130.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu132 ? _menu132.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu134 ? _menu134.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER
							&& getAmountInGUISlot(entity, 9) == 0 && (100 <= lvl || !(world instanceof ServerLevel _serverLevelGR137 && _serverLevelGR137.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack138 = new ItemStack(PalamodModItems.ENDIUM_BACKPACK.get()).copy();
							_setstack138.setCount(1);
							_menu.getSlots().get(9).set(_setstack138);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu139 ? _menu139.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu141 ? _menu141.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_CHEST.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu143 ? _menu143.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu145 ? _menu145.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu147 ? _menu147.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.HOPPER.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu149 ? _menu149.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu151 ? _menu151.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu153 ? _menu153.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu155 ? _menu155.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER
							&& getAmountInGUISlot(entity, 9) == 0 && (70 <= lvl || !(world instanceof ServerLevel _serverLevelGR158 && _serverLevelGR158.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack159 = new ItemStack(PalamodModItems.PALADUM_BACKPACK.get()).copy();
							_setstack159.setCount(1);
							_menu.getSlots().get(9).set(_setstack159);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu160 ? _menu160.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu162 ? _menu162.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.TITANE_CHEST
									.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu164 ? _menu164.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu166 ? _menu166.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu168 ? _menu168.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.HOPPER.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu170 ? _menu170.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.TITANE_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu172 ? _menu172.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu174 ? _menu174.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu176 ? _menu176.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER
							&& getAmountInGUISlot(entity, 9) == 0 && (53 <= lvl || !(world instanceof ServerLevel _serverLevelGR179 && _serverLevelGR179.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack180 = new ItemStack(PalamodModItems.TITANE_BACKPACK.get()).copy();
							_setstack180.setCount(1);
							_menu.getSlots().get(9).set(_setstack180);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu181 ? _menu181.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu183 ? _menu183.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.AMETHYST_CHEST.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu185 ? _menu185.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu187 ? _menu187.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu189 ? _menu189.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.HOPPER.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu191 ? _menu191.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.AMETHYST_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu193 ? _menu193.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu195 ? _menu195.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu197 ? _menu197.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER
							&& getAmountInGUISlot(entity, 9) == 0 && (35 <= lvl || !(world instanceof ServerLevel _serverLevelGR200 && _serverLevelGR200.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack201 = new ItemStack(PalamodModItems.AMETHYST_BACKPACK.get()).copy();
							_setstack201.setCount(1);
							_menu.getSlots().get(9).set(_setstack201);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu202 ? _menu202.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(Identifier.parse("minecraft:wool")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu204 ? _menu204.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(Identifier.parse("minecraft:wool")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu206 ? _menu206.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(Identifier.parse("minecraft:wool")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu208 ? _menu208.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.FURNACE_UPGRADE.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu210 ? _menu210.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.PISTON.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu212 ? _menu212.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.FURNACE_UPGRADE.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu214 ? _menu214.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(Identifier.parse("minecraft:planks")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu216 ? _menu216.getSlots().get(7).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(Identifier.parse("minecraft:planks")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu218 ? _menu218.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(Identifier.parse("minecraft:planks")))
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 0
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu222 ? _menu222.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModBlocks.ELEVATOR_WHITE.get().asItem())
							&& (13 <= lvl || !(world instanceof ServerLevel _serverLevelGR224 && _serverLevelGR224.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack225 = new ItemStack(PalamodModBlocks.ELEVATOR_WHITE.get()).copy();
							_setstack225.setCount(1);
							_menu.getSlots().get(9).set(_setstack225);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu226 ? _menu226.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.COMPRESSED_PALADIUM
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu228 ? _menu228.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu230 ? _menu230.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu232 ? _menu232.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu234 ? _menu234.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_SEEDPLANTER.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu236 ? _menu236.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu238 ? _menu238.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu240 ? _menu240.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu242 ? _menu242.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 0
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu246 ? _menu246.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.ENDIUM_SEEDPLANTER.get())
							&& (65 <= lvl || !(world instanceof ServerLevel _serverLevelGR248 && _serverLevelGR248.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack249 = new ItemStack(PalamodModItems.ENDIUM_SEEDPLANTER.get()).copy();
							_setstack249.setCount(1);
							_menu.getSlots().get(9).set(_setstack249);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu250 ? _menu250.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT
							.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu252 ? _menu252.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu254 ? _menu254.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu256 ? _menu256.getSlots().get(3).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu258 ? _menu258.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.PALADIUM_SEEDPLANTER.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu260 ? _menu260.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu262 ? _menu262.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu264 ? _menu264.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu266 ? _menu266.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 0
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu270 ? _menu270.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.GREEN_PALADIUM_SEEDPLANTER.get())
							&& (65 <= lvl || !(world instanceof ServerLevel _serverLevelGR272 && _serverLevelGR272.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack273 = new ItemStack(PalamodModItems.GREEN_PALADIUM_SEEDPLANTER.get()).copy();
							_setstack273.setCount(1);
							_menu.getSlots().get(9).set(_setstack273);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu274 ? _menu274.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu276 ? _menu276.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu278 ? _menu278.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu280 ? _menu280.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu282 ? _menu282.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.TITANE_SEEDPLANTER.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu284 ? _menu284.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu286 ? _menu286.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu288 ? _menu288.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu290 ? _menu290.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 0
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu294 ? _menu294.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.PALADIUM_SEEDPLANTER.get())
							&& (65 <= lvl || !(world instanceof ServerLevel _serverLevelGR296 && _serverLevelGR296.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack297 = new ItemStack(PalamodModItems.PALADIUM_SEEDPLANTER.get()).copy();
							_setstack297.setCount(1);
							_menu.getSlots().get(9).set(_setstack297);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu298 ? _menu298.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu300 ? _menu300.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu302 ? _menu302.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu304 ? _menu304.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu306 ? _menu306.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.TITANE_SEEDPLANTER.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu308 ? _menu308.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu310 ? _menu310.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu312 ? _menu312.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu314 ? _menu314.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 0
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu318 ? _menu318.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.PALADIUM_SEEDPLANTER.get())
							&& (65 <= lvl || !(world instanceof ServerLevel _serverLevelGR320 && _serverLevelGR320.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack321 = new ItemStack(PalamodModItems.PALADIUM_SEEDPLANTER.get()).copy();
							_setstack321.setCount(1);
							_menu.getSlots().get(9).set(_setstack321);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu322 ? _menu322.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu324 ? _menu324.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COMPRESSED_TITANE.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu326 ? _menu326.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu328 ? _menu328.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu330 ? _menu330.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.AMETHYST_SEEDPLANTER.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu332 ? _menu332.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu334 ? _menu334.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu336 ? _menu336.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu338 ? _menu338.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_STICK
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 0
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu342 ? _menu342.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.TITANE_SEEDPLANTER.get())
							&& (30 <= lvl || !(world instanceof ServerLevel _serverLevelGR344 && _serverLevelGR344.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack345 = new ItemStack(PalamodModItems.TITANE_SEEDPLANTER.get()).copy();
							_setstack345.setCount(1);
							_menu.getSlots().get(9).set(_setstack345);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu346 ? _menu346.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu348 ? _menu348.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu350 ? _menu350.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu352 ? _menu352.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu354 ? _menu354.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == PalamodModItems.COMPRESSED_AMETHYST.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu356 ? _menu356.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu358 ? _menu358.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu360 ? _menu360.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_STICK
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu362 ? _menu362.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_STICK
									.get()
							&& (getAmountInGUISlot(entity, 9) == 0 || getAmountInGUISlot(entity, 9) < 0
									&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu366 ? _menu366.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == PalamodModItems.AMETHYST_SEEDPLANTER.get())
							&& (10 <= lvl || !(world instanceof ServerLevel _serverLevelGR368 && _serverLevelGR368.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack369 = new ItemStack(PalamodModItems.AMETHYST_SEEDPLANTER.get()).copy();
							_setstack369.setCount(1);
							_menu.getSlots().get(9).set(_setstack369);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu370 ? _menu370.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu372 ? _menu372.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu374 ? _menu374.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu376 ? _menu376.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu378 ? _menu378.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu380 ? _menu380.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu382 ? _menu382.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu384 ? _menu384.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu386 ? _menu386.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (5 <= lvl || !(world instanceof ServerLevel _serverLevelGR393 && _serverLevelGR393.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack394 = new ItemStack(PalamodModItems.AMETHYST_HOE.get()).copy();
							_setstack394.setCount(1);
							_menu.getSlots().get(9).set(_setstack394);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu395 ? _menu395.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu397 ? _menu397.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu399 ? _menu399.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu401 ? _menu401.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu403 ? _menu403.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu405 ? _menu405.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu407 ? _menu407.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu409 ? _menu409.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu411 ? _menu411.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (20 <= lvl || !(world instanceof ServerLevel _serverLevelGR418 && _serverLevelGR418.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack419 = new ItemStack(PalamodModItems.TITANE_HOE.get()).copy();
							_setstack419.setCount(1);
							_menu.getSlots().get(9).set(_setstack419);
							_player.containerMenu.broadcastChanges();
						}
						is_a_craft = true;
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu420 ? _menu420.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu422 ? _menu422.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT
									.get()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu424 ? _menu424.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu426 ? _menu426.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.STICK
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu428 ? _menu428.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu430 ? _menu430.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu432 ? _menu432.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu434 ? _menu434.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu436 ? _menu436.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
							&& getAmountInGUISlot(entity, 5) == 0 && getAmountInGUISlot(entity, 6) == 0 && getAmountInGUISlot(entity, 8) == 0 && getAmountInGUISlot(entity, 9) == 0 && getAmountInGUISlot(entity, 3) == 0
							&& (50 <= lvl || !(world instanceof ServerLevel _serverLevelGR443 && _serverLevelGR443.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get())))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
							ItemStack _setstack444 = new ItemStack(PalamodModItems.PALADIUM_HOE.get()).copy();
							_setstack444.setCount(1);
							_menu.getSlots().get(9).set(_setstack444);
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