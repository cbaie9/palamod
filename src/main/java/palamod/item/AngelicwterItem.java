
package palamod.item;

import net.minecraft.network.chat.Component;

public class AngelicwterItem extends BucketItem {

	public AngelicwterItem() {
		super(PalamodModFluids.ANGELICWTER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}

}
