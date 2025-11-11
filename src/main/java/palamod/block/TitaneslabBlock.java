package palamod.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class TitaneslabBlock extends SlabBlock {
	public TitaneslabBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(2f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}
}