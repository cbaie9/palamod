
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FakepaladiumoreBlock extends Block {
	public FakepaladiumoreBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.FIRE).sound(SoundType.STONE).strength(6f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}