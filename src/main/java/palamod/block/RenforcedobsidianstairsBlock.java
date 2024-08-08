
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RenforcedobsidianstairsBlock extends StairBlock {
	public RenforcedobsidianstairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(-1, 3600000).dynamicShape());
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