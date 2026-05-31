package palamod.block;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class FrozenobsidianBlock extends Block {
	public FrozenobsidianBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(10f, 100f).requiresCorrectToolForDrops());
	}

	public static class Item extends BlockItem {
		public Item(Item.Properties properties) {
			super(PalamodModBlocks.FROZEN_OBSIDIAN.get(), properties);
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
			componentConsumer.accept(Component.translatable("block.palamod.frozen_obsidian.description_0"));
		}
	}
}