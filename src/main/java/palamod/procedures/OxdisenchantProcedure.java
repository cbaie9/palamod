package palamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;

public class OxdisenchantProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack item_dis = ItemStack.EMPTY;
		double dis_num = 0;
		item_dis = new ItemStack(ForgeRegistries.ITEMS
				.getValue(new ResourceLocation(((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))));
		dis_num = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount();
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount(), _player.inventoryMenu.getCraftSlots());
		}
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = item_dis.copy();
			_setstack.setCount((int) dis_num);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
	}
}
