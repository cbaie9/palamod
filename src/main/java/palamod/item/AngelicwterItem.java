package palamod.item;

import palamod.init.PalamodModFluids;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class AngelicwterItem extends BucketItem {
	public AngelicwterItem() {
		super(PalamodModFluids.ANGELIC_WATER.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}