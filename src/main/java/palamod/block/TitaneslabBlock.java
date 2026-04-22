package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class TitaneslabBlock extends SlabBlock {
	public TitaneslabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(2f, 10f).requiresCorrectToolForDrops());
	}
}