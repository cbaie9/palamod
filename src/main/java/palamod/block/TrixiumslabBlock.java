package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class TrixiumslabBlock extends SlabBlock {
	public TrixiumslabBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops());
	}
}