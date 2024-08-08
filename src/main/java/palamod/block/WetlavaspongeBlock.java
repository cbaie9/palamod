
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class WetlavaspongeBlock extends Block {
	public WetlavaspongeBlock() {
		super(BlockBehaviour.Properties.of().liquid().sound(SoundType.GLASS).strength(0.7f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}