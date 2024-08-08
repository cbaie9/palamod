
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ObsidianslabBlock extends SlabBlock {
	public ObsidianslabBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(10f).dynamicShape());
	}
}