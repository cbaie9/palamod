package palamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;

public class ObsidiantrapdoorBlock extends TrapDoorBlock {
	public ObsidiantrapdoorBlock() {
		super(BlockSetType.STONE, BlockBehaviour.Properties.of().strength(50f, 1200f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.BASEDRUM));
	}
}