
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TruetresureBlock extends Block {
	public TruetresureBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		Truetresure_dropProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}