
package palamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SlimepadBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = DirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public SlimepadBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_GREEN).sound(SoundType.SLIME_BLOCK).strength(1f, 10f).requiresCorrectToolForDrops().noCollission().friction(0.8f).noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> box(1, 1, 1, 15, 9, 15);
			case NORTH -> box(1, 1, 1, 15, 9, 15);
			case EAST -> box(1, 1, 1, 15, 9, 15);
			case WEST -> box(1, 1, 1, 15, 9, 15);
			case UP -> box(1, 1, 1, 15, 15, 9);
			case DOWN -> box(1, 1, 7, 15, 15, 15);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return this.defaultBlockState().setValue(FACING, context.getClickedFace()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.BLOCKED;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		SlimeprocessProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}