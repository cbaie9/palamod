package palamod.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class DeadButtonBlock extends ButtonBlock {
	public DeadButtonBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.OAK, 30, properties.sound(SoundType.WOOD).strength(0.5f).noCollission().pushReaction(PushReaction.DESTROY));
	}
}