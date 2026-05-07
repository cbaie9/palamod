package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class PortalprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack key = ItemStack.EMPTY;
		double level_alchi = 0;
		double level_required = 0;
		BlockState angle_block = Blocks.AIR.defaultBlockState();
		BlockState shiny_wood = Blocks.AIR.defaultBlockState();
		BlockState key_block = Blocks.AIR.defaultBlockState();
		level_alchi = GetleveljobsProcedure.execute(world, entity, "alchi");
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.AMETHYST_PORTALBLOCK.get()) {
			angle_block = PalamodModBlocks.AMETHYST_BLOCK.get().defaultBlockState();
			shiny_wood = PalamodModBlocks.SHINY_JACARANDA_WOOD.get().defaultBlockState();
			key = new ItemStack(PalamodModItems.AMETHYST_PORTAL_KEY.get()).copy();
			level_required = 6;
			key_block = (blockStateWithInt(PalamodModBlocks.KEY_PORTAL_BLOCK.get().defaultBlockState(), "blockstate", 1));
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.TITANE_PORTAL_BLOCK.get()) {
			angle_block = PalamodModBlocks.TITANE_BLOCK.get().defaultBlockState();
			shiny_wood = PalamodModBlocks.SHINY_JUDEECERCIS_WOOD.get().defaultBlockState();
			key = new ItemStack(PalamodModItems.TITANE_PORTAL_KEY.get()).copy();
			level_required = 9;
			key_block = (blockStateWithInt(PalamodModBlocks.KEY_PORTAL_BLOCK.get().defaultBlockState(), "blockstate", 2));
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.PALADIUM_PORTAL_BLOCK.get()) {
			angle_block = PalamodModBlocks.PALADIUM_BLOCK.get().defaultBlockState();
			shiny_wood = PalamodModBlocks.SHINY_ERABLE_WOOD.get().defaultBlockState();
			key = new ItemStack(PalamodModItems.PALADIUM_PORTAL_KEY.get()).copy();
			level_required = 12;
			key_block = (blockStateWithInt(PalamodModBlocks.KEY_PORTAL_BLOCK.get().defaultBlockState(), "blockstate", 3));
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.ENDIUM_PORTAL_BLOCK.get()) {
			angle_block = PalamodModBlocks.ENDIUM_PORTAL_ANGLE_BLOCK.get().defaultBlockState();
			shiny_wood = PalamodModBlocks.SHINY_ERABLE_WOOD.get().defaultBlockState();
			key = new ItemStack(PalamodModItems.ENDIUM_PORTAL_KEY.get()).copy();
			level_required = 20;
			key_block = (blockStateWithInt(PalamodModBlocks.KEY_PORTAL_BLOCK.get().defaultBlockState(), "blockstate", 4));
		}
		PalamodMod.LOGGER.debug(("Portal dump :" + "\n" + "angle block :" + angle_block + "\n" + "shiny wood :" + shiny_wood + "\n" + "key : " + key + "\n" + getBlockNBTString(world, BlockPos.containing(x, y, z), "position") + "\n"
				+ getBlockNBTLogic(world, BlockPos.containing(x, y, z), "portal_powered") + IsgameserversideProcedure.execute()));
		if (CheckportalstructureProcedure.execute(world, x, y, z, angle_block, shiny_wood) && key.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
				&& (level_alchi >= level_required || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDUSE)) && !getBlockNBTLogic(world, BlockPos.containing(x, y, z), "portal_powered")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().put("key", (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).saveOptional(world.registryAccess()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack21 = new ItemStack(Blocks.AIR).copy();
				_setstack21.setCount(0);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack21);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("portal_powered", true);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			world.setBlock(BlockPos.containing(x, y + 1, z), key_block, 3);
			if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "position")).equals("west")) {
				{
					Direction _dir = Direction.WEST;
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				world.setBlock(BlockPos.containing(x - 1, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 2, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 2, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 2, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 3, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 3, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 3, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
			} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "position")).equals("east")) {
				{
					Direction _dir = Direction.EAST;
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				world.setBlock(BlockPos.containing(x + 1, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 2, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 2, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 2, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 3, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 3, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 3, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
			} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "position")).equals("north")) {
				{
					Direction _dir = Direction.NORTH;
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				world.setBlock(BlockPos.containing(x + 1, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z - 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z - 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z - 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z - 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z - 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z - 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
			} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "position")).equals("south")) {
				{
					Direction _dir = Direction.SOUTH;
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				world.setBlock(BlockPos.containing(x + 1, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z + 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z + 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z + 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z + 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z + 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z + 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
			}
		}
	}

	private static BlockState blockStateWithInt(BlockState blockState, String property, int newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty(property);
		return prop instanceof IntegerProperty ip && prop.getPossibleValues().contains(newValue) ? blockState.setValue(ip, newValue) : blockState;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}