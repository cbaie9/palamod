package palamod.item;

import palamod.procedures.Givepotionx2expProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class DoubleexppotionItem extends Item {
	public DoubleexppotionItem(Item.Properties properties) {
		super(properties.stacksTo(1).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(1f).alwaysEdible().build(), Consumables.DEFAULT_DRINK));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		Givepotionx2expProcedure.execute(entity);
		return retval;
	}
}