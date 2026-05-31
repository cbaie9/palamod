package palamod.block;

import palamod.procedures.OstryasapdropProcedure;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.UntintedParticleLeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class Ostrya_woodLeavesBlock extends UntintedParticleLeavesBlock {
	public Ostrya_woodLeavesBlock(BlockBehaviour.Properties properties) {
		super(0f, ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, -10124477), properties.sound(SoundType.GRASS).strength(0.2f).noOcclusion().ignitedByLava().isSuffocating((bs, br, bp) -> false).isViewBlocking((bs, br, bp) -> false));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 30;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, ItemStack toolStack, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, toolStack, willHarvest, fluid);
		OstryasapdropProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
		return retval;
	}
}