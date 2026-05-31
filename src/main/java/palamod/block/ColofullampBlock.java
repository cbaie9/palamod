package palamod.block;

import palamod.procedures.ColofullampRedstoneOffProcedure;

import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

public class ColofullampBlock extends Block {
	public ColofullampBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.LANTERN).strength(1f, 10f).instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, orientation, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
		} else {
			ColofullampRedstoneOffProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		}
	}
}