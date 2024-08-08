
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ObsidiandoorBlock extends DoorBlock {
	public ObsidiandoorBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(10f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false).dynamicShape(), BlockSetType.IRON);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}