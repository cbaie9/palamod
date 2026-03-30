package palamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class SoftenedtrixiumoreBlock extends Block {
	public SoftenedtrixiumoreBlock(BlockBehaviour.Properties properties) {
<<<<<<< Updated upstream
		super(properties.strength(1.3f, 10f).instrument(NoteBlockInstrument.BASEDRUM));
=======
		super(properties.strength(1.3f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
>>>>>>> Stashed changes
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}