
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TitaneOreBlock extends Block {
	public TitaneOreBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(5.05f, 18.1194915919f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}