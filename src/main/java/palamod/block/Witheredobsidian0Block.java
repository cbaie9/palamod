package palamod.block;

import palamod.procedures.UptierwitheredobsidianProcedure;

import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

public class Witheredobsidian0Block extends Block {
	public Witheredobsidian0Block(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_BLACK).strength(50f, 1200f).requiresCorrectToolForDrops().pushReaction(PushReaction.BLOCK));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.DAMAGE_OTHER;
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, orientation, moving);
		UptierwitheredobsidianProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}