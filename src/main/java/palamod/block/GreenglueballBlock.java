package palamod.block;

import palamod.procedures.SlowgreenglowballProcedure;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.function.Function;

public class GreenglueballBlock extends Block {
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	private final Function<BlockState, VoxelShape> shapes = this.makeShapes();

	public GreenglueballBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.SLIME_BLOCK).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).ignitedByLava());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private Function<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(0, 0, 5, 16, 1, 11), box(1, 0, 11, 15, 1, 13), box(1, 0, 3, 15, 1, 5), box(3, 0, 13, 13, 1, 15), box(3, 0, 1, 13, 1, 3), box(5, 0, 15, 11, 1, 16), box(5, 0, 0, 11, 1, 1));
				case EAST -> Shapes.or(box(5, 0, 0, 11, 1, 16), box(3, 0, 1, 5, 1, 15), box(11, 0, 1, 13, 1, 15), box(1, 0, 3, 3, 1, 13), box(13, 0, 3, 15, 1, 13), box(0, 0, 5, 1, 1, 11), box(15, 0, 5, 16, 1, 11));
				case WEST -> Shapes.or(box(5, 0, 0, 11, 1, 16), box(11, 0, 1, 13, 1, 15), box(3, 0, 1, 5, 1, 15), box(13, 0, 3, 15, 1, 13), box(1, 0, 3, 3, 1, 13), box(15, 0, 5, 16, 1, 11), box(0, 0, 5, 1, 1, 11));
				default -> Shapes.or(box(0, 0, 5, 16, 1, 11), box(1, 0, 3, 15, 1, 5), box(1, 0, 11, 15, 1, 13), box(3, 0, 1, 13, 1, 3), box(3, 0, 13, 13, 1, 15), box(5, 0, 0, 11, 1, 1), box(5, 0, 15, 11, 1, 16));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.apply(state);
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		if (context.getClickedFace().getAxis() == Direction.Axis.Y)
			return state.setValue(FACING, Direction.NORTH);
		return state.setValue(FACING, context.getClickedFace());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier, boolean isPrecise) {
		super.entityInside(blockstate, world, pos, entity, insideBlockEffectApplier, isPrecise);
		SlowgreenglowballProcedure.execute(entity);
	}
}