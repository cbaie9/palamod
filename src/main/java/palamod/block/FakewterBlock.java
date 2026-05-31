package palamod.block;

import palamod.procedures.FakewaterMobplayerCollidesBlockProcedure;

import palamod.init.PalamodModFluids;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class FakewterBlock extends LiquidBlock {
	public FakewterBlock(BlockBehaviour.Properties properties) {
		super(PalamodModFluids.FAKE_WATER.get(), properties.mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier) {
		super.entityInside(blockstate, world, pos, entity, insideBlockEffectApplier);
		FakewaterMobplayerCollidesBlockProcedure.execute(world, entity);
	}
}