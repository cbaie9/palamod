
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TitaneslabBlock extends SlabBlock {
	public TitaneslabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(2f, 10f).requiresCorrectToolForDrops().dynamicShape());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}