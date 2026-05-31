package palamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;

public class PaladiumslabBlock extends SlabBlock {
	public PaladiumslabBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(1f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}