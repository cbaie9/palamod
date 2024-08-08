
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PaladiumGreenblockBlock extends Block {
	public PaladiumGreenblockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}