
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class WithertntBlock extends Block {
	public WithertntBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.FIRE).sound(SoundType.CROP).strength(0.75f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.DANGER_OTHER;
	}

	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		return true;
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
			SpawnwithertntProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		}
	}
}