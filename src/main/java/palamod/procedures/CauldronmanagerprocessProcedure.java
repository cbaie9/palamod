package palamod.procedures;

import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class CauldronmanagerprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, String type) {
		if (type == null)
			return;
		boolean layer_two = false;
		boolean pass = false;
		boolean layer_one = false;
		double y_core = 0;
		double x_core = 0;
		double failsafe_crash = 0;
		double z_core = 0;
		double z_while = 0;
		double x_while = 0;
		if (pass) {/*layer 1*/
			x_while = x_core - 3;
			z_while = z_core - 3;
			while (!(x_while == x_core + 3 && z_while == z_core + 3)) {
				if (world instanceof ServerLevel _serverLevelGR4 && _serverLevelGR4.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
					PalamodMod.LOGGER.debug(("log l1 : x: " + x_while + "  y: " + y_core + " z: " + z_while));
					if (failsafe_crash >= 50) {
						break;
					} else {
						failsafe_crash = failsafe_crash + 1;
					}
					if (x_core == x_while && z_core == z_while) {
						x_while = x_while + 1;
						continue;
					}
					if (!(PalamodModBlocks.CAULDRON.get() == (world.getBlockState(BlockPos.containing(x_while, y_core, z_while))).getBlock())) {
						if (world instanceof ServerLevel _serverLevelGR8 && _serverLevelGR8.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
							PalamodMod.LOGGER.debug(("layer 1 failed : x: " + x_while + "  y: " + y_core + " z: " + z_while));
						}
						break;
					}
					if (x_while == x_core + 3) {
						z_while = z_while + 1;
						x_while = x_core - 3;
					} else {
						x_while = x_while + 1;
					}
				}
			}
			layer_one = PalamodModBlocks.CAULDRON.get() == (world.getBlockState(BlockPos.containing(x_core + 3, y_core, z_core + 3))).getBlock() && x_while == x_core + 3 && z_while == z_core + 3;
			if (world instanceof ServerLevel _serverLevelGR12 && _serverLevelGR12.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
				PalamodMod.LOGGER.info("layer1 : " + layer_one + "\n" + (x_while == x_core + 3) + "\n" + (z_while == z_core + 3));
			} /*layer 2*/
			x_while = x_core - 2;
			z_while = z_core - 2;
			failsafe_crash = 0;
			while (!(x_while == x_core + 2 && z_while == z_core + 2)) {
				if (world instanceof ServerLevel _serverLevelGR13 && _serverLevelGR13.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
					PalamodMod.LOGGER.debug(("log l2 : x: " + x_while + "  y: " + y_core + " z: " + z_while));
				}
				if (failsafe_crash >= 50) {
					break;
				} else {
					failsafe_crash = failsafe_crash + 1;
				}
				if (z_core - 1 <= z_while && z_core + 1 >= z_while || x_core - 1 <= x_while && x_core + 1 >= x_while) {
					if (x_while == x_core + 2) {
						z_while = z_while + 1;
						x_while = x_core - 2;
					} else {
						x_while = x_while + 1;
					}
					continue;
				}
				if (!(PalamodModBlocks.CAULDRON.get() == (world.getBlockState(BlockPos.containing(x_while, y_core + 1, z_while))).getBlock())) {
					break;
				}
				if (x_while == x_core + 2) {
					z_while = z_while + 1;
					x_while = x_core - 2;
				} else {
					x_while = x_while + 1;
				}
			}
			layer_two = PalamodModBlocks.CAULDRON.get() == (world.getBlockState(BlockPos.containing(x_core + 2, y_core + 1, z_core + 2))).getBlock() && x_while == x_core + 2 && z_while == z_core + 2;
			if (world instanceof ServerLevel _serverLevelGR19 && _serverLevelGR19.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
				PalamodMod.LOGGER.info("layer2 : " + layer_two);
			}
			if (layer_one && layer_two) {
				if (("setup").equals(type)) {
					PalamodMod.LOGGER.info("the structure is completed, unlocking cauldron");
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x_core, y_core, z_core);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean("cauldron_open", true);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x_core + 3, y_core, z_core);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x_core - 3, y_core, z_core);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					x_while = x_core - 1;
					z_while = z_core - 1;
					failsafe_crash = 0;
					while (!(x_while == x_core + 1 && z_while == z_core + 1)) {
						if (world instanceof ServerLevel _serverLevelGR24 && _serverLevelGR24.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
							PalamodMod.LOGGER.debug(("log place : x: " + x_while + "  y: " + y_core + " z: " + z_while));
						}
						if (failsafe_crash >= 50) {
							break;
						} else {
							failsafe_crash = failsafe_crash + 1;
						}
						world.setBlock(BlockPos.containing(x_while, y_core + 1, z_while), PalamodModBlocks.ANGELIC_WATER.get().defaultBlockState(), 3);
						if (x_while == x_core + 1) {
							z_while = z_while + 1;
							x_while = x_core - 1;
						} else {
							x_while = x_while + 1;
						}
					}
					world.setBlock(BlockPos.containing(x_core + 1, y_core + 1, z_core + 1), PalamodModBlocks.ANGELIC_WATER.get().defaultBlockState(), 3);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"kill @e[type=minecraft:item,distance=..5,limit=1]");
				}
			} else {
				if (("break").equals(type) && getBlockNBTLogic(world, BlockPos.containing(x_core, y_core, z_core), "cauldron_open")) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x_core, y_core, z_core);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean("cauldron_open", false);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					PalamodMod.LOGGER.info("the structure is broken, replacing");
					if (PalamodModBlocks.CAULDRON.get() == (world.getBlockState(BlockPos.containing(x_core + 3, y_core, z_core))).getBlock()) {
						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x_core + 3, y_core, z_core);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
					if (PalamodModBlocks.CAULDRON.get() == (world.getBlockState(BlockPos.containing(x_core - 3, y_core, z_core))).getBlock()) {
						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x_core - 3, y_core, z_core);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
					x_while = x_core - 1;
					z_while = z_core - 1;
					failsafe_crash = 0;
					while (!(x_while == x_core + 1 && z_while == z_core + 1)) {
						if (world instanceof ServerLevel _serverLevelGR38 && _serverLevelGR38.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
							PalamodMod.LOGGER.debug(("log place : x: " + x_while + "  y: " + y_core + " z: " + z_while));
						}
						if (failsafe_crash >= 50) {
							break;
						} else {
							failsafe_crash = failsafe_crash + 1;
						}
						if (PalamodModBlocks.ANGELIC_WATER.get() == (world.getBlockState(BlockPos.containing(x_while, y_core + 1, z_while))).getBlock()) {
							world.setBlock(BlockPos.containing(x_while, y_core + 1, z_while), Blocks.LAVA.defaultBlockState(), 3);
						}
						if (x_while == x_core + 1) {
							z_while = z_while + 1;
							x_while = x_core - 1;
						} else {
							x_while = x_while + 1;
						}
					}
					world.setBlock(BlockPos.containing(x_core + 1, y_core + 1, z_core + 1), Blocks.LAVA.defaultBlockState(), 3);
				}
			}
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}
}