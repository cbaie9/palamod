package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.component.DataComponents;

public class SpecialmoneyprocessProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (getAmountInGUISlot(entity, 0) != 0) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack3 = ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY).copy()).copy();
				_setstack3.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack3);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		} else {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack4 = new ItemStack(PalamodModItems.MONEY_ITEM.get()).copy();
				_setstack4.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack4);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if (("").equals((entity instanceof Player _entity5 && _entity5.containerMenu instanceof PalamodModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(0, "name", "") : "")) {
			{
				final String _tagName = "Is_pname";
				final boolean _tagValue = false;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "Money_spename";
				final String _tagValue = (entity.getDisplayName().getString());
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
			}
		} else {
			{
				final String _tagName = "Is_pname";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "Money_spename";
				final String _tagValue = ((entity instanceof Player _entity13 && _entity13.containerMenu instanceof PalamodModMenus.MenuAccessor _menu13) ? _menu13.getMenuState(0, "name", "") : "");
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
			}
		}
		if (("").equals((entity instanceof Player _entity16 && _entity16.containerMenu instanceof PalamodModMenus.MenuAccessor _menu16) ? _menu16.getMenuState(0, "amount", "") : "")) {
			{
				final String _tagName = "Money_amount";
				final double _tagValue = 1000;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
		} else {
			{
				final String _tagName = "Money_amount";
				final double _tagValue = parseDouble((entity instanceof Player _entity19 && _entity19.containerMenu instanceof PalamodModMenus.MenuAccessor _menu19) ? _menu19.getMenuState(0, "amount", "") : "");
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if ((entity instanceof Player _entity22 && _entity22.containerMenu instanceof PalamodModMenus.MenuAccessor _menu22) && _menu22.getMenuState(1, "custom_destructible", false)) {
			{
				final String _tagName = "destri_money";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
		} else {
			{
				final String _tagName = "destri_money";
				final boolean _tagValue = false;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof PalamodModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}

	private static double parseDouble(String s) {
		try {
			return Double.parseDouble(s.trim());
		} catch (Exception e) {
			return 0;
		}
	}
}