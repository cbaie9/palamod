
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class GuardianblockBlock extends Block {
	public GuardianblockBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}