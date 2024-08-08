
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FindiumoredeepslateBlock extends Block {
	public FindiumoredeepslateBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(3f, 5f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}