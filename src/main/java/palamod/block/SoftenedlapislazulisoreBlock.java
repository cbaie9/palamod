package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class SoftenedlapislazulisoreBlock extends Block {
	public SoftenedlapislazulisoreBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHERRACK).strength(1f, 10f).requiresCorrectToolForDrops());
	}
}