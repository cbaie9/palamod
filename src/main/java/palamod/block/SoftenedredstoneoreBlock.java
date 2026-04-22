package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class SoftenedredstoneoreBlock extends Block {
	public SoftenedredstoneoreBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.NETHERRACK).strength(1f, 10f).requiresCorrectToolForDrops());
	}
}