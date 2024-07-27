
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class PalamodModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == PalamodModBlocks.JACARANDA_PLANKS.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == PalamodModBlocks.JACARANDA_STAIRS.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == PalamodModBlocks.JACARANDA_SLAB.get().asItem())
			event.setBurnTime(150);
		else if (itemstack.getItem() == PalamodModBlocks.JACARANDA_LOG.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModBlocks.JACARANDA_WOOD.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModBlocks.OSTRYA_WOOD_PLANKS.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == PalamodModBlocks.OSTRYA_WOOD_STAIRS.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == PalamodModBlocks.OSTRYA_WOOD_SLAB.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == PalamodModBlocks.JUDEECERCIS_PLANKS.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == PalamodModBlocks.JUDEECERCIS_STAIRS.get().asItem())
			event.setBurnTime(150);
		else if (itemstack.getItem() == PalamodModBlocks.JUDEECERCIS_SLAB.get().asItem())
			event.setBurnTime(100);
		else if (itemstack.getItem() == PalamodModBlocks.ERABLE_LOG.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == PalamodModBlocks.ERABLE_PLANKS.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == PalamodModBlocks.ERABLE_STAIRS.get().asItem())
			event.setBurnTime(800);
		else if (itemstack.getItem() == PalamodModBlocks.ERABLE_SLAB.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModBlocks.ERABLE_WOOD.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == PalamodModBlocks.ERABLE_FENCE.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModBlocks.ERABLE_FENCE_GATE.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModBlocks.ERABLE_LEAVES.get().asItem())
			event.setBurnTime(60);
		else if (itemstack.getItem() == PalamodModBlocks.JUDEECERCIS_FENCE_GATE.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModBlocks.JUDEECERCIS_FENCE.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModBlocks.JUDEECERCIS_LEAVES.get().asItem())
			event.setBurnTime(60);
		else if (itemstack.getItem() == PalamodModBlocks.JACARANDA_LEAVES.get().asItem())
			event.setBurnTime(60);
		else if (itemstack.getItem() == PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().asItem())
			event.setBurnTime(60);
		else if (itemstack.getItem() == PalamodModBlocks.JACARANDA_FENCE_GATE.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModBlocks.JACARANDA_FENCE.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModBlocks.OSTRYA_WOOD_FENCE.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModBlocks.OSTRYA_WOOD_FENCE_GATE.get().asItem())
			event.setBurnTime(400);
		else if (itemstack.getItem() == PalamodModItems.GOLD_MIXEDCOAL.get())
			event.setBurnTime(16000);
		else if (itemstack.getItem() == PalamodModItems.AMETHYST_MIXEDCOAL.get())
			event.setBurnTime(20000);
		else if (itemstack.getItem() == PalamodModItems.TITANE_MIXED_COAL.get())
			event.setBurnTime(24000);
		else if (itemstack.getItem() == PalamodModItems.PALADIUM_MIXED_CHARCOAL.get())
			event.setBurnTime(32000);
		else if (itemstack.getItem() == PalamodModBlocks.WETLAVASPONGE.get().asItem())
			event.setBurnTime(32000);
	}
}
