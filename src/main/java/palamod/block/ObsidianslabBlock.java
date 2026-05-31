package palamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;

public class ObsidianslabBlock extends SlabBlock {
	public ObsidianslabBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(50f, 1200f).instrument(NoteBlockInstrument.BASEDRUM));
	}
}