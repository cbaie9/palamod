package palamod.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CompressedspongeBlock extends Block {
	public CompressedspongeBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.LILY_PAD).strength(0.65f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}