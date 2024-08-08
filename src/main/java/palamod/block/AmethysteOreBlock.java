
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class AmethysteOreBlock extends Block {
	public AmethysteOreBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(3f, 15.1571656651f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}