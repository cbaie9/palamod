package palamod.item;

import palamod.init.PalamodModFluids;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class FakewterItem extends BucketItem {
	public FakewterItem(Item.Properties properties) {
		super(PalamodModFluids.FAKE_WATER.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}