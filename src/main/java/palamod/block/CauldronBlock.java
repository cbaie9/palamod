package palamod.block;

import palamod.procedures.CauldronbreakProcedure;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class CauldronBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 1);

	public CauldronBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(1f, 10f).requiresCorrectToolForDrops());
		this.registerDefaultState(this.stateDefinition.any().setValue(BLOCKSTATE, 0));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(BLOCKSTATE, 0);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		CauldronbreakProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}

	@Override
	public void wasExploded(ServerLevel world, BlockPos pos, Explosion e) {
		super.wasExploded(world, pos, e);
		CauldronbreakProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}