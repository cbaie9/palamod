package palamod.item;

import palamod.init.PalamodModFluids;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class FakewterItem extends BucketItem {
	public FakewterItem() {
		super(PalamodModFluids.FAKE_WATER.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}