package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class PalahelpstickmodedamageProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(PalamodModItems.AMETHYST_STICK.get()).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(0).set(_setstack0);
			ItemStack _setstack1 = new ItemStack(PalamodModItems.TITANE_SWORD.get()).copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(1).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(PalamodModItems.AMETHYST_STICK.get()).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(2).set(_setstack2);
			ItemStack _setstack3 = new ItemStack(PalamodModBlocks.PALADIUM_SPIKE.get()).copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(3).set(_setstack3);
			ItemStack _setstack4 = new ItemStack(PalamodModBlocks.PALADIUM_SPIKE.get()).copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(4).set(_setstack4);
			ItemStack _setstack5 = new ItemStack(PalamodModItems.JUMP_STICK.get()).copy();
			_setstack5.setCount(1);
			_menu.getSlots().get(5).set(_setstack5);
			_menu.getSlots().get(7).set(ItemStack.EMPTY);
			_menu.getSlots().get(9).set(ItemStack.EMPTY);
			_menu.getSlots().get(10).set(ItemStack.EMPTY);
			_menu.getSlots().get(11).set(ItemStack.EMPTY);
			_menu.getSlots().get(13).set(ItemStack.EMPTY);
			_menu.getSlots().get(15).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		entity.getPersistentData().putDouble("mode_stick", 5);
	}
}