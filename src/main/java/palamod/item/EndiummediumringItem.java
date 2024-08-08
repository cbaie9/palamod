
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class EndiummediumringItem extends Item {
	public EndiummediumringItem() {
		super(new Item.Properties().durability(1600).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RingprocessendiumProcedure.execute(entity, itemstack);
	}
}