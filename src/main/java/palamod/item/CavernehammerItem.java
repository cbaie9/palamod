package palamod.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class CavernehammerItem extends Item {
	public CavernehammerItem() {
		super(new Item.Properties().durability(256));
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState state) {
		return 3f;
	}
}