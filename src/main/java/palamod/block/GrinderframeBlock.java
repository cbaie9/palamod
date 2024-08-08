
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class GrinderframeBlock extends Block {
	public GrinderframeBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}