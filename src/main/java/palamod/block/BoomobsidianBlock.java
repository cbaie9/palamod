package palamod.block;

import palamod.procedures.KaboomobsidianProcedure;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class BoomobsidianBlock extends Block {
	public BoomobsidianBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(50f, 1200f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		KaboomobsidianProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}

	@Override
	public void wasExploded(ServerLevel world, BlockPos pos, Explosion e) {
		super.wasExploded(world, pos, e);
		KaboomobsidianProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}