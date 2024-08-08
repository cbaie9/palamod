
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CompressedspongeBlock extends Block {
	public CompressedspongeBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.LILY_PAD).strength(0.65f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}