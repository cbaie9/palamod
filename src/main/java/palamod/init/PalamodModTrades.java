
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package palamod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PalamodModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == PalamodModVillagerProfessions.SANTA.get()) {
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get(), 64),

					new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()), 1, 5000, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(PalamodModBlocks.PALADIUM_BLOCK.get(), 64),

					new ItemStack(Blocks.DIRT), 1000, 500, 0f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Blocks.SNOW_BLOCK, 2), new ItemStack(Items.SNOWBALL, 8), new ItemStack(Items.POWDER_SNOW_BUCKET), 20, 7, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(PalamodModBlocks.UPLOADER.get()), new ItemStack(PalamodModItems.PALADIUM_APPLE.get(), 6), new ItemStack(Items.MUSIC_DISC_CAT), 2, 45, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Blocks.AMETHYST_BLOCK, 10),

					new ItemStack(Blocks.JUKEBOX), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(PalamodModBlocks.PALADIUM_GREEN_BLOCK.get(), 2),

					new ItemStack(PalamodModItems.ENDIUM_NUGGET.get(), 2), 1, 5000, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(PalamodModBlocks.PALADIUM_GREEN_BLOCK.get(), 4),

					new ItemStack(Blocks.DIRT, 2), 10, 1500, 0.05f));
		}
	}
}
