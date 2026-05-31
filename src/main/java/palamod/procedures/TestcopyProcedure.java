package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class TestcopyProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack vr = ItemStack.EMPTY;
		vr = new ItemStack(PalamodModItems.PLATE.get()).copy();
		vr.applyComponents((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getComponents());
		if (entity instanceof Player _player) {
			ItemStack _setstack = (vr.copy()).copy();
			_setstack.setCount(1);
			_player.getInventory().placeItemBackInInventory(_setstack);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = vr.copy();
			_setstack.setCount(1);
			_player.getInventory().placeItemBackInInventory(_setstack);
		}
	}
}