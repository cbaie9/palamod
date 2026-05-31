package palamod.block;

import palamod.procedures.CraftableToolTipTextProcedure;

import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class CompressedspongeBlock extends Block {
	public CompressedspongeBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.LILY_PAD).strength(0.65f, 10f));
	}

	public static class Item extends BlockItem {
		public Item(Item.Properties properties) {
			super(PalamodModBlocks.COMPRESSED_SPONGE.get(), properties);
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
			Entity entity = PalamodMod.clientPlayer();
			String hoverText = CraftableToolTipTextProcedure.execute(itemstack);
			if (hoverText != null) {
				for (String line : hoverText.split("\n")) {
					componentConsumer.accept(Component.literal(line));
				}
			}
		}
	}
}