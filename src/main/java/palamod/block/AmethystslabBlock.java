package palamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class AmethystslabBlock extends SlabBlock {
	public AmethystslabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST).strength(1.1f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}