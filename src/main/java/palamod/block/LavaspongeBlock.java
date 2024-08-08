
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class LavaspongeBlock extends Block {
	public LavaspongeBlock() {
		super(BlockBehaviour.Properties.of().liquid().sound(SoundType.GLASS).strength(0.7f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		LavaspongeprocessProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		LavaspongeprocessProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}