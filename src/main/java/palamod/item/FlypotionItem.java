package palamod.item;

import palamod.procedures.FseffectEffectStartedappliedProcedure;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class FlypotionItem extends Item {
	public FlypotionItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(5f).build()).usingConvertsTo(Items.GLASS_BOTTLE));
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState state) {
		return 0f;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		FseffectEffectStartedappliedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}
}