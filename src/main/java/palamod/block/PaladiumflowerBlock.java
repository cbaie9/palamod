package palamod.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class PaladiumflowerBlock extends FlowerBlock {
	public PaladiumflowerBlock(BlockBehaviour.Properties properties) {
		super(MobEffects.SPEED, 100, properties.mapColor(MapColor.PLANT).sound(SoundType.GRASS).instabreak().postProcess((bs, br, bp) -> bp).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 15).noCollision()
				.offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}
}