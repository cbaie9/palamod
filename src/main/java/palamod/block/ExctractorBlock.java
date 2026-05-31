package palamod.block;

import palamod.procedures.ExtratorblockstateprocessProcedure;
import palamod.procedures.ExtractorprocesstickProcedure;

import palamod.block.entity.ExctractorBlockEntity;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.ARGB;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.function.Function;

public class ExctractorBlock extends Block implements EntityBlock {
	public static final EnumProperty<Direction> FACING = DirectionalBlock.FACING;
	public static final BooleanProperty FIOLE = BooleanProperty.create("fiole");
	public static final IntegerProperty EXTRACTED_SAP = IntegerProperty.create("extracted_sap", 0, 15);
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 9);
	private final Function<BlockState, VoxelShape> shapes = this.makeShapes();

	public ExctractorBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_MAGENTA).strength(1f, 10f).requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.BASEDRUM));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FIOLE, false).setValue(EXTRACTED_SAP, 0).setValue(BLOCKSTATE, 0));
	}

	private Function<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(5, 5, 14.05, 11, 11, 15.3), box(5.75, 5.75, 5.5, 10.25, 10.25, 14.3), box(6.75, 3.5, 6.8, 9.25, 6, 9.3), box(6.5, 3.25, 6.55, 9.5, 3.75, 9.55), box(7.25, 10.25, 7.3, 8.75, 12.75, 8.8),
						box(7.25, 11.5, 5.8, 8.75, 12.75, 7.3), box(7.25, 11.5, 8.8, 8.75, 12.75, 10.3), box(8.75, 11.5, 7.3, 10.25, 12.75, 8.8), box(5.75, 11.5, 7.3, 7.25, 12.75, 8.8));
				case EAST -> Shapes.or(box(0.7, 5, 5, 1.95, 11, 11), box(1.7, 5.75, 5.75, 10.5, 10.25, 10.25), box(6.7, 3.5, 6.75, 9.2, 6, 9.25), box(6.45, 3.25, 6.5, 9.45, 3.75, 9.5), box(7.2, 10.25, 7.25, 8.7, 12.75, 8.75),
						box(8.7, 11.5, 7.25, 10.2, 12.75, 8.75), box(5.7, 11.5, 7.25, 7.2, 12.75, 8.75), box(7.2, 11.5, 8.75, 8.7, 12.75, 10.25), box(7.2, 11.5, 5.75, 8.7, 12.75, 7.25));
				case WEST -> Shapes.or(box(14.05, 5, 5, 15.3, 11, 11), box(5.5, 5.75, 5.75, 14.3, 10.25, 10.25), box(6.8, 3.5, 6.75, 9.3, 6, 9.25), box(6.55, 3.25, 6.5, 9.55, 3.75, 9.5), box(7.3, 10.25, 7.25, 8.8, 12.75, 8.75),
						box(5.8, 11.5, 7.25, 7.3, 12.75, 8.75), box(8.8, 11.5, 7.25, 10.3, 12.75, 8.75), box(7.3, 11.5, 5.75, 8.8, 12.75, 7.25), box(7.3, 11.5, 8.75, 8.8, 12.75, 10.25));
				case UP -> Shapes.or(box(5, 0.7, 5, 11, 1.95, 11), box(5.75, 1.7, 5.75, 10.25, 10.5, 10.25), box(6.75, 6.7, 3.5, 9.25, 9.2, 6), box(6.5, 6.45, 3.25, 9.5, 9.45, 3.75), box(7.25, 7.2, 10.25, 8.75, 8.7, 12.75),
						box(7.25, 8.7, 11.5, 8.75, 10.2, 12.75), box(7.25, 5.7, 11.5, 8.75, 7.2, 12.75), box(8.75, 7.2, 11.5, 10.25, 8.7, 12.75), box(5.75, 7.2, 11.5, 7.25, 8.7, 12.75));
				case DOWN -> Shapes.or(box(5, 14.05, 5, 11, 15.3, 11), box(5.75, 5.5, 5.75, 10.25, 14.3, 10.25), box(6.75, 6.8, 10, 9.25, 9.3, 12.5), box(6.5, 6.55, 12.25, 9.5, 9.55, 12.75), box(7.25, 7.3, 3.25, 8.75, 8.8, 5.75),
						box(7.25, 5.8, 3.25, 8.75, 7.3, 4.5), box(7.25, 8.8, 3.25, 8.75, 10.3, 4.5), box(8.75, 7.3, 3.25, 10.25, 8.8, 4.5), box(5.75, 7.3, 3.25, 7.25, 8.8, 4.5));
				default -> Shapes.or(box(5, 5, 0.7, 11, 11, 1.95), box(5.75, 5.75, 1.7, 10.25, 10.25, 10.5), box(6.75, 3.5, 6.7, 9.25, 6, 9.2), box(6.5, 3.25, 6.45, 9.5, 3.75, 9.45), box(7.25, 10.25, 7.2, 8.75, 12.75, 8.7),
						box(7.25, 11.5, 8.7, 8.75, 12.75, 10.2), box(7.25, 11.5, 5.7, 8.75, 12.75, 7.2), box(5.75, 11.5, 7.2, 7.25, 12.75, 8.7), box(8.75, 11.5, 7.2, 10.25, 12.75, 8.7));
			};
		}, FIOLE, EXTRACTED_SAP);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.apply(state);
	}

	@Override
	public Integer getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
		return ARGB.opaque(-26266);
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, FIOLE, EXTRACTED_SAP, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(FACING, context.getClickedFace()).setValue(FIOLE, false).setValue(EXTRACTED_SAP, 0).setValue(BLOCKSTATE, 0);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.BLOCKED;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		ExtractorprocesstickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		ExtratorblockstateprocessProcedure.execute(world, x, y, z, blockstate, entity);
		return InteractionResult.SUCCESS;
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
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	protected void affectNeighborsAfterRemoval(BlockState blockstate, ServerLevel world, BlockPos blockpos, boolean flag) {
		Containers.updateNeighboursAfterDestroy(blockstate, world, blockpos);
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos, Direction direction) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof ExctractorBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}