package palamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class TrixiumoredeepslateBlock extends Block {
	public TrixiumoredeepslateBlock() {
		super(BlockBehaviour.Properties.of().strength(1.3f, 10f).instrument(NoteBlockInstrument.BASEDRUM));
	}
}