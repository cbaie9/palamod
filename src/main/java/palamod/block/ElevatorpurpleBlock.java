package palamod.block;

import palamod.procedures.Elevator_processProcedure;
import palamod.procedures.CraftableToolTipTextProcedure;

import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.function.Consumer;

public class ElevatorpurpleBlock extends Block {
	public ElevatorpurpleBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		Elevator_processProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	public static class Item extends BlockItem {
		public Item(Item.Properties properties) {
			super(PalamodModBlocks.ELEVATOR_PURPLE.get(), properties);
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
			Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : PalamodMod.clientPlayer();
			String hoverText = CraftableToolTipTextProcedure.execute(itemstack);
			if (hoverText != null) {
				for (String line : hoverText.split("\n")) {
					componentConsumer.accept(Component.literal(line));
				}
			}
		}
	}
}