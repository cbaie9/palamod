package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class WetlavaspongeBlock extends Block {
	public WetlavaspongeBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.7f, 10f));
	}
}