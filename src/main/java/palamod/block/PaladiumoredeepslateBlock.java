
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PaladiumoredeepslateBlock extends Block {
	public PaladiumoredeepslateBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(3f, 5f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}