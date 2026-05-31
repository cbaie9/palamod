package palamod.item;

import palamod.PalamodMod;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class MiichalengeItem extends Item {
	public MiichalengeItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(1).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "disc_mii_chalenge"))));
	}

	@Override
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}