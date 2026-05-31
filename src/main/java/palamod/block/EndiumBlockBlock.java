package palamod.block;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class EndiumBlockBlock extends Block {
	public EndiumBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(5f, 10f).requiresCorrectToolForDrops());
	}

	public static class Item extends BlockItem {
		public Item(Item.Properties properties) {
			super(PalamodModBlocks.ENDIUM_BLOCK.get(), properties);
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
			componentConsumer.accept(Component.translatable("block.palamod.endium_block.description_0"));
		}
	}
}