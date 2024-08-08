
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class ChunkanaslyserItem extends Item {
	public ChunkanaslyserItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Cause a big freeze when used"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		AnalyserdendProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}