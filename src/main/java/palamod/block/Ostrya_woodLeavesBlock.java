
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Ostrya_woodLeavesBlock extends LeavesBlock {
	public Ostrya_woodLeavesBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.GRASS).strength(0.2f).noOcclusion());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 1;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 30;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		OstryasapdropProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
		return retval;
	}
}