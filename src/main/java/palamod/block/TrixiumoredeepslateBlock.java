
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TrixiumoredeepslateBlock extends Block {
	public TrixiumoredeepslateBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.3f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}