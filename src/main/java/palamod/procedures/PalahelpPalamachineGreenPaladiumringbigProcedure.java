package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class PalahelpPalamachineGreenPaladiumringbigProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack damaged_item = ItemStack.EMPTY;
		if (10 == entity.getPersistentData().getDouble("mode_palamachine_craft")) {
			damaged_item = new ItemStack(PalamodModItems.GREEN_PALADIUM_BIG_RING.get()).copy();
			if (world instanceof ServerLevel _level) {
				damaged_item.hurtAndBreak(50, _level, null, _stkprov -> {
				});
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack2 = new ItemStack(PalamodModBlocks.PALADIUM_GREEN_BLOCK.get()).copy();
				_setstack2.setCount(1);
				_menu.getSlots().get(0).set(_setstack2);
				ItemStack _setstack3 = new ItemStack(PalamodModBlocks.PALADIUM_GREEN_BLOCK.get()).copy();
				_setstack3.setCount(1);
				_menu.getSlots().get(1).set(_setstack3);
				ItemStack _setstack4 = damaged_item.copy();
				_setstack4.setCount(1);
				_menu.getSlots().get(2).set(_setstack4);
				ItemStack _setstack5 = new ItemStack(PalamodModItems.GREEN_PALADIUM_INGOT.get()).copy();
				_setstack5.setCount(1);
				_menu.getSlots().get(3).set(_setstack5);
				ItemStack _setstack6 = new ItemStack(PalamodModBlocks.PALADIUM_GREEN_BLOCK.get()).copy();
				_setstack6.setCount(1);
				_menu.getSlots().get(4).set(_setstack6);
				ItemStack _setstack7 = new ItemStack(PalamodModItems.GREEN_PALADIUM_BIG_RING.get()).copy();
				_setstack7.setCount(1);
				_menu.getSlots().get(5).set(_setstack7);
				_menu.getSlots().get(7).set(ItemStack.EMPTY);
				_menu.getSlots().get(9).set(ItemStack.EMPTY);
				_menu.getSlots().get(10).set(ItemStack.EMPTY);
				_menu.getSlots().get(11).set(ItemStack.EMPTY);
				_menu.getSlots().get(13).set(ItemStack.EMPTY);
				_menu.getSlots().get(15).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			entity.getPersistentData().putDouble("mode_palamachine_craft", 11);
		} else {
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack15 = new ItemStack(PalamodModItems.COMPRESSED_GREEN_PALADUM.get()).copy();
				_setstack15.setCount(1);
				_menu.getSlots().get(0).set(_setstack15);
				ItemStack _setstack16 = new ItemStack(PalamodModItems.GREEN_PALADIUM_INGOT.get()).copy();
				_setstack16.setCount(1);
				_menu.getSlots().get(1).set(_setstack16);
				ItemStack _setstack17 = new ItemStack(PalamodModItems.GREEN_PALADIUM_MEDIUM_RING.get()).copy();
				_setstack17.setCount(1);
				_menu.getSlots().get(2).set(_setstack17);
				ItemStack _setstack18 = new ItemStack(PalamodModItems.GREEN_PALADIUM_INGOT.get()).copy();
				_setstack18.setCount(1);
				_menu.getSlots().get(3).set(_setstack18);
				ItemStack _setstack19 = new ItemStack(PalamodModItems.GREEN_PALADIUM_INGOT.get()).copy();
				_setstack19.setCount(1);
				_menu.getSlots().get(4).set(_setstack19);
				ItemStack _setstack20 = new ItemStack(PalamodModItems.GREEN_PALADIUM_BIG_RING.get()).copy();
				_setstack20.setCount(1);
				_menu.getSlots().get(5).set(_setstack20);
				_menu.getSlots().get(7).set(ItemStack.EMPTY);
				_menu.getSlots().get(9).set(ItemStack.EMPTY);
				_menu.getSlots().get(10).set(ItemStack.EMPTY);
				_menu.getSlots().get(11).set(ItemStack.EMPTY);
				_menu.getSlots().get(13).set(ItemStack.EMPTY);
				_menu.getSlots().get(15).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			entity.getPersistentData().putDouble("mode_palamachine_craft", 10);
		}
	}
}