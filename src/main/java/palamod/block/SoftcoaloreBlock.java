package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class SoftcoaloreBlock extends Block {
	public SoftcoaloreBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHERRACK).strength(1f, 10f).requiresCorrectToolForDrops());
	}
}