package palamod.item;

import palamod.PalamodMod;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class RoulettepaladiennediscItem extends Item {
	public RoulettepaladiennediscItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(1).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(PalamodMod.MODID, "disc_roulette_paladienne"))));
	}
}