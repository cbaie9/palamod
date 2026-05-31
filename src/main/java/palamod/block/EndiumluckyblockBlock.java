package palamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class EndiumluckyblockBlock extends Block {
	public EndiumluckyblockBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(1f, 10f).instrument(NoteBlockInstrument.BASEDRUM));
	}
}