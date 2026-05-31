package palamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.util.ARGB;
import net.minecraft.core.BlockPos;

public class SoftstonestairsBlock extends StairBlock {
	public SoftstonestairsBlock(BlockBehaviour.Properties properties) {
		super(Blocks.AIR.defaultBlockState(), properties.mapColor(MapColor.STONE).sound(SoundType.NETHERRACK).strength(0.4f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 0.4f;
	}

	@Override
	public Integer getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
		return ARGB.opaque(-8620714);
	}
}