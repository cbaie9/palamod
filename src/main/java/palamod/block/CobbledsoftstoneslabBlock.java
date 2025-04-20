
package palamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.util.FastColor;
import net.minecraft.core.BlockPos;

public class CobbledsoftstoneslabBlock extends SlabBlock {
	public CobbledsoftstoneslabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(0.4f).requiresCorrectToolForDrops().dynamicShape());
	}

	@Override
	public Integer getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
		return FastColor.ARGB32.opaque(-8620714);
	}
}
