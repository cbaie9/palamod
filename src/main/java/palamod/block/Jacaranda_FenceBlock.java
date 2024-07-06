
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Jacaranda_FenceBlock extends FenceBlock {
	public Jacaranda_FenceBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2f, 3f).requiresCorrectToolForDrops().dynamicShape().forceSolidOn());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}
}