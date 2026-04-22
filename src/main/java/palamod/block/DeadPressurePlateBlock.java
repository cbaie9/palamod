package palamod.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class DeadPressurePlateBlock extends PressurePlateBlock {
	public DeadPressurePlateBlock() {
		super(BlockSetType.OAK, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.5f).noCollission().pushReaction(PushReaction.DESTROY).ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn());
	}
}