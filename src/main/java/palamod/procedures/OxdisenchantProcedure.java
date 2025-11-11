package palamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class OxdisenchantProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack item_dis = ItemStack.EMPTY;
		double dis_num = 0;
		item_dis = new ItemStack(
				BuiltInRegistries.ITEM.get(ResourceLocation.parse(((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))))
				.copy();
		dis_num = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount();
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount(), _player.inventoryMenu.getCraftSlots());
		}
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack9 = item_dis.copy();
			_setstack9.setCount((int) dis_num);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack9);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
	}
}