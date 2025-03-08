package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class OpengodvillagerguiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		PalamodMod.LOGGER.info("open_gui");
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get()).copy();
			_setstack.setCount(64);
			((Slot) _slots.get(2)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
			_setstack.setCount(1);
			((Slot) _slots.get(3)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
	}
}
