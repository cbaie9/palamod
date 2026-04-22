package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class AmethysteBlockBlock extends Block {
	public AmethysteBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST).strength(5f, 10f).requiresCorrectToolForDrops());
	}
}