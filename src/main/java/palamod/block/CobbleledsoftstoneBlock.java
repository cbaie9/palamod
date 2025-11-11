package palamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.util.ARGB;
import net.minecraft.core.BlockPos;

public class CobbleledsoftstoneBlock extends Block {
	public CobbleledsoftstoneBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.STONE).strength(0.4f).requiresCorrectToolForDrops());
	}

	@Override
	public Integer getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
		return ARGB.opaque(-8620714);
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}