
package palamod.block;

import palamod.block.entity.ExctractorBlockEntity;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ExctractorBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 11);
	public static final DirectionProperty FACING = DirectionalBlock.FACING;

	public ExctractorBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1f, 10f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				if (s.getValue(BLOCKSTATE) == 5)
					return 0;
				if (s.getValue(BLOCKSTATE) == 6)
					return 0;
				if (s.getValue(BLOCKSTATE) == 7)
					return 0;
				if (s.getValue(BLOCKSTATE) == 8)
					return 0;
				if (s.getValue(BLOCKSTATE) == 9)
					return 0;
				if (s.getValue(BLOCKSTATE) == 10)
					return 0;
				if (s.getValue(BLOCKSTATE) == 11)
					return 0;
				return 0;
			}
		}.getLightLevel())).requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public float[] getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
		return new float[]{1f, 0.6f, 0.4f};
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
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(5, 5, 14.75, 11, 11, 16), box(5.75, 5.75, 6.2, 10.25, 10.25, 15), box(6.75, 3.5, 7.5, 9.25, 6, 10), box(6.5, 3.25, 7.25, 9.5, 3.75, 10.25), box(7.25, 10.25, 8, 8.75, 12.75, 9.5),
					box(7.25, 11.5, 6.5, 8.75, 12.75, 8), box(7.25, 11.5, 9.5, 8.75, 12.75, 11), box(8.75, 11.5, 8, 10.25, 12.75, 9.5), box(5.75, 11.5, 8, 7.25, 12.75, 9.5));
			case NORTH -> Shapes.or(box(5, 5, 0, 11, 11, 1.25), box(5.75, 5.75, 1, 10.25, 10.25, 9.8), box(6.75, 3.5, 6, 9.25, 6, 8.5), box(6.5, 3.25, 5.75, 9.5, 3.75, 8.75), box(7.25, 10.25, 6.5, 8.75, 12.75, 8),
					box(7.25, 11.5, 8, 8.75, 12.75, 9.5), box(7.25, 11.5, 5, 8.75, 12.75, 6.5), box(5.75, 11.5, 6.5, 7.25, 12.75, 8), box(8.75, 11.5, 6.5, 10.25, 12.75, 8));
			case EAST -> Shapes.or(box(14.75, 5, 5, 16, 11, 11), box(6.2, 5.75, 5.75, 15, 10.25, 10.25), box(7.5, 3.5, 6.75, 10, 6, 9.25), box(7.25, 3.25, 6.5, 10.25, 3.75, 9.5), box(8, 10.25, 7.25, 9.5, 12.75, 8.75),
					box(6.5, 11.5, 7.25, 8, 12.75, 8.75), box(9.5, 11.5, 7.25, 11, 12.75, 8.75), box(8, 11.5, 5.75, 9.5, 12.75, 7.25), box(8, 11.5, 8.75, 9.5, 12.75, 10.25));
			case WEST -> Shapes.or(box(0, 5, 5, 1.25, 11, 11), box(1, 5.75, 5.75, 9.8, 10.25, 10.25), box(6, 3.5, 6.75, 8.5, 6, 9.25), box(5.75, 3.25, 6.5, 8.75, 3.75, 9.5), box(6.5, 10.25, 7.25, 8, 12.75, 8.75), box(8, 11.5, 7.25, 9.5, 12.75, 8.75),
					box(5, 11.5, 7.25, 6.5, 12.75, 8.75), box(6.5, 11.5, 8.75, 8, 12.75, 10.25), box(6.5, 11.5, 5.75, 8, 12.75, 7.25));
			case UP -> Shapes.or(box(5, 14.75, 5, 11, 16, 11), box(5.75, 6.2, 5.75, 10.25, 15, 10.25), box(6.75, 7.5, 3.5, 9.25, 10, 6), box(6.5, 7.25, 3.25, 9.5, 10.25, 3.75), box(7.25, 8, 10.25, 8.75, 9.5, 12.75),
					box(7.25, 6.5, 11.5, 8.75, 8, 12.75), box(7.25, 9.5, 11.5, 8.75, 11, 12.75), box(5.75, 8, 11.5, 7.25, 9.5, 12.75), box(8.75, 8, 11.5, 10.25, 9.5, 12.75));
			case DOWN -> Shapes.or(box(5, 0, 5, 11, 1.25, 11), box(5.75, 1, 5.75, 10.25, 9.8, 10.25), box(6.75, 6, 10, 9.25, 8.5, 12.5), box(6.5, 5.75, 12.25, 9.5, 8.75, 12.75), box(7.25, 6.5, 3.25, 8.75, 8, 5.75), box(7.25, 8, 3.25, 8.75, 9.5, 4.5),
					box(7.25, 5, 3.25, 8.75, 6.5, 4.5), box(5.75, 6.5, 3.25, 7.25, 8, 4.5), box(8.75, 6.5, 3.25, 10.25, 8, 4.5));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getClickedFace());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.BLOCKED;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ExctractorBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof ExctractorBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof ExctractorBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
