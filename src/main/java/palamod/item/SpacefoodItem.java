
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class SpacefoodItem extends Item {
	public SpacefoodItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(7).saturationMod(1f).alwaysEat().meat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		Spacefood_processProcedure.execute(world, x, y, z, entity);
		return retval;
	}
}