package palamod.item;

import palamod.procedures.Spacefood_processProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class SpacefoodItem extends Item {
	public SpacefoodItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(7).saturationModifier(1f).alwaysEdible().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		Spacefood_processProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}
}