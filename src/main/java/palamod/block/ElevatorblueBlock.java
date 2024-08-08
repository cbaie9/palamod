
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ElevatorblueBlock extends Block {
	public ElevatorblueBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		Elevator_processProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}