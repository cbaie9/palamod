
package palamod.block;

import palamod.procedures.PaladiumspikedamageProcedure;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class PaladiumspikeBlock extends Block {
	public static final DirectionProperty FACING = DirectionalBlock.FACING;

	public PaladiumspikeBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
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
			default -> Shapes.or(box(0, 0, 0, 16, 16, 1), box(1, 1, 1, 15, 15, 3), box(2, 2, 3, 14, 14, 4), box(3, 3, 4, 13, 13, 5), box(4, 4, 5, 12, 12, 7), box(5, 5, 7, 11, 11, 8), box(6, 6, 8, 10, 10, 9), box(7, 7, 9, 9, 9, 11));
			case NORTH -> Shapes.or(box(0, 0, 15, 16, 16, 16), box(1, 1, 13, 15, 15, 15), box(2, 2, 12, 14, 14, 13), box(3, 3, 11, 13, 13, 12), box(4, 4, 9, 12, 12, 11), box(5, 5, 8, 11, 11, 9), box(6, 6, 7, 10, 10, 8), box(7, 7, 5, 9, 9, 7));
			case EAST -> Shapes.or(box(0, 0, 0, 1, 16, 16), box(1, 1, 1, 3, 15, 15), box(3, 2, 2, 4, 14, 14), box(4, 3, 3, 5, 13, 13), box(5, 4, 4, 7, 12, 12), box(7, 5, 5, 8, 11, 11), box(8, 6, 6, 9, 10, 10), box(9, 7, 7, 11, 9, 9));
			case WEST -> Shapes.or(box(15, 0, 0, 16, 16, 16), box(13, 1, 1, 15, 15, 15), box(12, 2, 2, 13, 14, 14), box(11, 3, 3, 12, 13, 13), box(9, 4, 4, 11, 12, 12), box(8, 5, 5, 9, 11, 11), box(7, 6, 6, 8, 10, 10), box(5, 7, 7, 7, 9, 9));
			case UP -> Shapes.or(box(0, 0, 0, 16, 1, 16), box(1, 1, 1, 15, 3, 15), box(2, 3, 2, 14, 4, 14), box(3, 4, 3, 13, 5, 13), box(4, 5, 4, 12, 7, 12), box(5, 7, 5, 11, 8, 11), box(6, 8, 6, 10, 9, 10), box(7, 9, 7, 9, 11, 9));
			case DOWN -> Shapes.or(box(0, 15, 0, 16, 16, 16), box(1, 13, 1, 15, 15, 15), box(2, 12, 2, 14, 13, 14), box(3, 11, 3, 13, 12, 13), box(4, 9, 4, 12, 11, 12), box(5, 8, 5, 11, 9, 11), box(6, 7, 6, 10, 8, 10), box(7, 5, 7, 9, 7, 9));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof PickaxeItem tieredItem)
			return tieredItem.getTier().getLevel() >= 2;
		return false;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		PaladiumspikedamageProcedure.execute(world, entity);
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		PaladiumspikedamageProcedure.execute(world, entity);
	}
}
