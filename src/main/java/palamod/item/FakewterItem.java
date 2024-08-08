
package palamod.item;

import net.minecraft.network.chat.Component;

public class FakewterItem extends BucketItem {

	public FakewterItem() {
		super(PalamodModFluids.FAKEWTER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}

}
