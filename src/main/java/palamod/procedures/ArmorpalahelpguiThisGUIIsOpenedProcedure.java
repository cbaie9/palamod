package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class ArmorpalahelpguiThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(PalamodModItems.AMETHYST_ARMOR_HELMET.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack2 = new ItemStack(PalamodModItems.AMETHYST_ARMOR_HELMET.get()).copy();
				_setstack2.setCount(1);
				_menu.getSlots().get(0).set(_setstack2);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.AMETHYST_ARMOR_CHESTPLATE.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack5 = new ItemStack(PalamodModItems.AMETHYST_ARMOR_CHESTPLATE.get()).copy();
				_setstack5.setCount(1);
				_menu.getSlots().get(1).set(_setstack5);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.AMETHYST_ARMOR_LEGGINGS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack8 = new ItemStack(PalamodModItems.AMETHYST_ARMOR_LEGGINGS.get()).copy();
				_setstack8.setCount(1);
				_menu.getSlots().get(2).set(_setstack8);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.AMETHYST_ARMOR_BOOTS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack11 = new ItemStack(PalamodModItems.AMETHYST_ARMOR_BOOTS.get()).copy();
				_setstack11.setCount(1);
				_menu.getSlots().get(3).set(_setstack11);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.TITANE_ARMOR_HELMET.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack14 = new ItemStack(PalamodModItems.TITANE_ARMOR_HELMET.get()).copy();
				_setstack14.setCount(1);
				_menu.getSlots().get(4).set(_setstack14);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.TITANE_ARMOR_CHESTPLATE.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack17 = new ItemStack(PalamodModItems.TITANE_ARMOR_CHESTPLATE.get()).copy();
				_setstack17.setCount(1);
				_menu.getSlots().get(5).set(_setstack17);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.TITANE_ARMOR_LEGGINGS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack20 = new ItemStack(PalamodModItems.TITANE_ARMOR_LEGGINGS.get()).copy();
				_setstack20.setCount(1);
				_menu.getSlots().get(6).set(_setstack20);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.TITANE_ARMOR_BOOTS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack23 = new ItemStack(PalamodModItems.TITANE_ARMOR_BOOTS.get()).copy();
				_setstack23.setCount(1);
				_menu.getSlots().get(7).set(_setstack23);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.PALADIUM_ARMOR_HELMET.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack26 = new ItemStack(PalamodModItems.PALADIUM_ARMOR_HELMET.get()).copy();
				_setstack26.setCount(1);
				_menu.getSlots().get(8).set(_setstack26);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.PALADIUM_ARMOR_CHESTPLATE.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(9).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack29 = new ItemStack(PalamodModItems.PALADIUM_ARMOR_CHESTPLATE.get()).copy();
				_setstack29.setCount(1);
				_menu.getSlots().get(9).set(_setstack29);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.PALADIUM_ARMOR_LEGGINGS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(10).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack32 = new ItemStack(PalamodModItems.PALADIUM_ARMOR_LEGGINGS.get()).copy();
				_setstack32.setCount(1);
				_menu.getSlots().get(10).set(_setstack32);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.PALADIUM_ARMOR_BOOTS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(11).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack35 = new ItemStack(PalamodModItems.PALADIUM_ARMOR_BOOTS.get()).copy();
				_setstack35.setCount(1);
				_menu.getSlots().get(11).set(_setstack35);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.ENDIUM_ARMOR_HELMET.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(12).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack38 = new ItemStack(PalamodModItems.ENDIUM_ARMOR_HELMET.get()).copy();
				_setstack38.setCount(1);
				_menu.getSlots().get(12).set(_setstack38);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.ENDIUM_ARMOR_CHESTPLATE.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(13).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack41 = new ItemStack(PalamodModItems.ENDIUM_ARMOR_CHESTPLATE.get()).copy();
				_setstack41.setCount(1);
				_menu.getSlots().get(13).set(_setstack41);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.ENDIUM_ARMOR_LEGGINGS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(14).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack44 = new ItemStack(PalamodModItems.ENDIUM_ARMOR_LEGGINGS.get()).copy();
				_setstack44.setCount(1);
				_menu.getSlots().get(14).set(_setstack44);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.ENDIUM_ARMOR_BOOTS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(15).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack47 = new ItemStack(PalamodModItems.ENDIUM_ARMOR_BOOTS.get()).copy();
				_setstack47.setCount(1);
				_menu.getSlots().get(15).set(_setstack47);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.MIXED_ENDIUM_ARMOR_HELMET.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(16).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack50 = new ItemStack(PalamodModItems.MIXED_ENDIUM_ARMOR_HELMET.get()).copy();
				_setstack50.setCount(1);
				_menu.getSlots().get(16).set(_setstack50);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.MIXED_ENDIUM_ARMOR_CHESTPLATE.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get(17).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack53 = new ItemStack(PalamodModItems.MIXED_ENDIUM_ARMOR_CHESTPLATE.get()).copy();
				_setstack53.setCount(1);
				_menu.getSlots().get(17).set(_setstack53);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.MIXED_ENDIUM_ARMOR_LEGGINGS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(18).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack56 = new ItemStack(PalamodModItems.MIXED_ENDIUM_ARMOR_LEGGINGS.get()).copy();
				_setstack56.setCount(1);
				_menu.getSlots().get(18).set(_setstack56);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.MIXED_ENDIUM_ARMOR_BOOTS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(11).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack59 = new ItemStack(PalamodModItems.MIXED_ENDIUM_ARMOR_BOOTS.get()).copy();
				_setstack59.setCount(1);
				_menu.getSlots().get(19).set(_setstack59);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.INVISIBLE_ARMOR_HELMET.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(20).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack62 = new ItemStack(PalamodModItems.INVISIBLE_ARMOR_HELMET.get()).copy();
				_setstack62.setCount(1);
				_menu.getSlots().get(20).set(_setstack62);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.INVISIBLE_ARMOR_CHESTPLATE.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(21).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack65 = new ItemStack(PalamodModItems.INVISIBLE_ARMOR_CHESTPLATE.get()).copy();
				_setstack65.setCount(1);
				_menu.getSlots().get(21).set(_setstack65);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.INVISIBLE_ARMOR_LEGGINGS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(22).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack68 = new ItemStack(PalamodModItems.INVISIBLE_ARMOR_LEGGINGS.get()).copy();
				_setstack68.setCount(1);
				_menu.getSlots().get(22).set(_setstack68);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.INVISIBLE_ARMOR_BOOTS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get(23).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack71 = new ItemStack(PalamodModItems.INVISIBLE_ARMOR_BOOTS.get()).copy();
				_setstack71.setCount(1);
				_menu.getSlots().get(23).set(_setstack71);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.RAINBOWARMOR_HELMET.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(24).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack74 = new ItemStack(PalamodModItems.RAINBOWARMOR_HELMET.get()).copy();
				_setstack74.setCount(1);
				_menu.getSlots().get(24).set(_setstack74);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.RAINBOWARMOR_CHESTPLATE.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu75 ? _menu75.getSlots().get(25).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack77 = new ItemStack(PalamodModItems.RAINBOWARMOR_CHESTPLATE.get()).copy();
				_setstack77.setCount(1);
				_menu.getSlots().get(25).set(_setstack77);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.RAINBOWARMOR_LEGGINGS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu78 ? _menu78.getSlots().get(26).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack80 = new ItemStack(PalamodModItems.RAINBOWARMOR_LEGGINGS.get()).copy();
				_setstack80.setCount(1);
				_menu.getSlots().get(26).set(_setstack80);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.RAINBOWARMOR_BOOTS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(27).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack83 = new ItemStack(PalamodModItems.RAINBOWARMOR_BOOTS.get()).copy();
				_setstack83.setCount(1);
				_menu.getSlots().get(27).set(_setstack83);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.SCUBA_HELMET.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu84 ? _menu84.getSlots().get(28).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack86 = new ItemStack(PalamodModItems.SCUBA_HELMET.get()).copy();
				_setstack86.setCount(1);
				_menu.getSlots().get(28).set(_setstack86);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.TRAVEL_ARMOR_CHESTPLATE.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu87 ? _menu87.getSlots().get(29).getItem() : ItemStack.EMPTY)
				.getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack89 = new ItemStack(PalamodModItems.TRAVEL_ARMOR_CHESTPLATE.get()).copy();
				_setstack89.setCount(1);
				_menu.getSlots().get(29).set(_setstack89);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.TRAVEL_ARMOR_LEGGINGS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(30).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack92 = new ItemStack(PalamodModItems.TRAVEL_ARMOR_LEGGINGS.get()).copy();
				_setstack92.setCount(1);
				_menu.getSlots().get(30).set(_setstack92);
				_player.containerMenu.broadcastChanges();
			}
		}
		if (!(PalamodModItems.TRAVEL_ARMOR_BOOTS.get() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu93 ? _menu93.getSlots().get(31).getItem() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack95 = new ItemStack(PalamodModItems.TRAVEL_ARMOR_BOOTS.get()).copy();
				_setstack95.setCount(1);
				_menu.getSlots().get(31).set(_setstack95);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}