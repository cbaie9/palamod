
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class UnknownblockBlock extends Block {
	public UnknownblockBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.BASALT).strength(1f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}