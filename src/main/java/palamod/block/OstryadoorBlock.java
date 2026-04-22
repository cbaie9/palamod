package palamod.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.DoorBlock;

public class OstryadoorBlock extends DoorBlock {
	public OstryadoorBlock() {
		super(BlockSetType.OAK, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).ignitedByLava().instrument(NoteBlockInstrument.BASS));
	}
}