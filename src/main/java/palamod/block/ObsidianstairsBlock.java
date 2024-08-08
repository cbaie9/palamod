
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ObsidianstairsBlock extends StairBlock {
	public ObsidianstairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(10f).dynamicShape());
	}

	@Override
	public float getExplosionResistance() {
		return 10f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}
}