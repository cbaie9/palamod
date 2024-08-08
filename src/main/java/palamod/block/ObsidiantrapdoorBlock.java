
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ObsidiantrapdoorBlock extends TrapDoorBlock {
	public ObsidiantrapdoorBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(10f, 100f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false).dynamicShape(),
				BlockSetType.STONE);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}