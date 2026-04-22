package palamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class UnknownblockBlock extends Block {
	public UnknownblockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BASALT).strength(1f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}