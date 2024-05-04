
package palamod.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class ClashkumizItem extends RecordItem {
	public ClashkumizItem() {
		super(6, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("palamod:clash_kumiz")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1800);
	}
}
