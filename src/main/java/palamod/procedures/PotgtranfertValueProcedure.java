package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class PotgtranfertValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
				.copyTag().getDoubleOr("Pickaxe_stone", 0) > 0) {
			if ((entity.getPersistentData().getStringOr("language", "")).equals("french")) {
				return "Xp actuel :" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0));
			} else {
				return "Actual Xp :" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("Pickaxe_stone", 0));
			}
		}
		return "The xp level of the potg must be superior to 0";
	}
}