package palamod.block;

import palamod.procedures.PortalblockbreakviaportalProcedure;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.google.common.collect.ImmutableMap;

public class KeyportalblockBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 5);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public KeyportalblockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(5f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BLOCKSTATE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(7, 10, -6, 8, 12, -5), box(7, 11, -5, 8, 13, -4), box(7, 13, -4, 8, 14, -3), box(7, 9, -5, 8, 11, -4), box(7, 9, -3, 8, 11, -2), box(7, 9, -4, 8, 11, -3), box(7, 13, -3, 8, 15, -2), box(7, 1, 6, 8, 3, 8),
						box(7, 2, 5, 8, 4, 7), box(7, 3, 4, 8, 5, 6), box(7, 4, 3, 8, 6, 5), box(7, 5, 2, 8, 7, 4), box(7, 6, 1, 8, 8, 3), box(7, 7, 0, 8, 9, 2), box(7, 8, -1, 8, 10, 1), box(7, 10, -1, 8, 14, 0), box(7, 9, -2, 8, 15, -1),
						box(7, 0, 7, 8, 2, 9), box(7, 11, -4, 8, 13, -2));
				case NORTH -> Shapes.or(box(8, 10, 21, 9, 12, 22), box(8, 11, 20, 9, 13, 21), box(8, 13, 19, 9, 14, 20), box(8, 9, 20, 9, 11, 21), box(8, 9, 18, 9, 11, 19), box(8, 9, 19, 9, 11, 20), box(8, 13, 18, 9, 15, 19), box(8, 1, 8, 9, 3, 10),
						box(8, 2, 9, 9, 4, 11), box(8, 3, 10, 9, 5, 12), box(8, 4, 11, 9, 6, 13), box(8, 5, 12, 9, 7, 14), box(8, 6, 13, 9, 8, 15), box(8, 7, 14, 9, 9, 16), box(8, 8, 15, 9, 10, 17), box(8, 10, 16, 9, 14, 17),
						box(8, 9, 17, 9, 15, 18), box(8, 0, 7, 9, 2, 9), box(8, 11, 18, 9, 13, 20));
				case EAST -> Shapes.or(box(-6, 10, 8, -5, 12, 9), box(-5, 11, 8, -4, 13, 9), box(-4, 13, 8, -3, 14, 9), box(-5, 9, 8, -4, 11, 9), box(-3, 9, 8, -2, 11, 9), box(-4, 9, 8, -3, 11, 9), box(-3, 13, 8, -2, 15, 9), box(6, 1, 8, 8, 3, 9),
						box(5, 2, 8, 7, 4, 9), box(4, 3, 8, 6, 5, 9), box(3, 4, 8, 5, 6, 9), box(2, 5, 8, 4, 7, 9), box(1, 6, 8, 3, 8, 9), box(0, 7, 8, 2, 9, 9), box(-1, 8, 8, 1, 10, 9), box(-1, 10, 8, 0, 14, 9), box(-2, 9, 8, -1, 15, 9),
						box(7, 0, 8, 9, 2, 9), box(-4, 11, 8, -2, 13, 9));
				case WEST -> Shapes.or(box(21, 10, 7, 22, 12, 8), box(20, 11, 7, 21, 13, 8), box(19, 13, 7, 20, 14, 8), box(20, 9, 7, 21, 11, 8), box(18, 9, 7, 19, 11, 8), box(19, 9, 7, 20, 11, 8), box(18, 13, 7, 19, 15, 8), box(8, 1, 7, 10, 3, 8),
						box(9, 2, 7, 11, 4, 8), box(10, 3, 7, 12, 5, 8), box(11, 4, 7, 13, 6, 8), box(12, 5, 7, 14, 7, 8), box(13, 6, 7, 15, 8, 8), box(14, 7, 7, 16, 9, 8), box(15, 8, 7, 17, 10, 8), box(16, 10, 7, 17, 14, 8),
						box(17, 9, 7, 18, 15, 8), box(7, 0, 7, 9, 2, 8), box(18, 11, 7, 20, 13, 8));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(BLOCKSTATE, 0);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		PortalblockbreakviaportalProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}

	@Override
	public void wasExploded(Level world, BlockPos pos, Explosion e) {
		super.wasExploded(world, pos, e);
		PortalblockbreakviaportalProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}