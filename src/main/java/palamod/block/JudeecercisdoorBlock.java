
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class JudeecercisdoorBlock extends DoorBlock {
	public JudeecercisdoorBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.WOOD).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).dynamicShape(), BlockSetType.STONE);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}