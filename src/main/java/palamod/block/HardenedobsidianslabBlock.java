
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class HardenedobsidianslabBlock extends SlabBlock {
	public HardenedobsidianslabBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(-1, 3600000).dynamicShape());
	}
}