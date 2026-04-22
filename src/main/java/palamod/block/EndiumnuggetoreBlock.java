package palamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class EndiumnuggetoreBlock extends Block {
	public EndiumnuggetoreBlock() {
		super(BlockBehaviour.Properties.of().strength(1f, 10f).instrument(NoteBlockInstrument.BASEDRUM));
	}
}