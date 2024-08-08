
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SpongetntBlock extends Block {
	public SpongetntBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.LILY_PAD).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
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
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
			SpawnprimedtntProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		}
		UpdateblockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}