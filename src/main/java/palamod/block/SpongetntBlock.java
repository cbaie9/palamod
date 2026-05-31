package palamod.block;

import palamod.procedures.UpdateblockProcedure;
import palamod.procedures.SpawnprimedtntProcedure;
import palamod.procedures.CraftableToolTipTextProcedure;

import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.function.Consumer;

public class SpongetntBlock extends Block {
	public SpongetntBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.LILY_PAD).strength(1f, 10f));
	}

	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		return true;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		UpdateblockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, orientation, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
			SpawnprimedtntProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		}
		UpdateblockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static class Item extends BlockItem {
		public Item(Item.Properties properties) {
			super(PalamodModBlocks.TNT_SPONGE.get(), properties);
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