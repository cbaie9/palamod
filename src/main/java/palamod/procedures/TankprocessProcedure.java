package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class TankprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String seve_string = "";
		double max_stock = 0;
		double decalc_blockstate = 0;
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
			PalamodMod.LOGGER.debug(("---------------------" + "\n" + "tank" + "\n" + "stock : " + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock") + "\n" + "type : " + getBlockNBTString(world, BlockPos.containing(x, y, z), "type")));
		}
		if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "setup")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("setup", true);
					_blockEntity.getPersistentData().putDouble("stock", 0);
					_blockEntity.getPersistentData().putString("type", "None");
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (1 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("type", 0)) {
			seve_string = "ostrya";
		} else if (2 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("type", 0)) {
			seve_string = "judeecercis";
		} else if (3 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("type", 0)) {
			seve_string = "jacaranda";
		} else if (4 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("type", 0)) {
			seve_string = "erable";
		} else {
			seve_string = "NTOSI_error";
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.AMETHYST_TANK.get()) {/*amethyst*/
			max_stock = 60;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.GOLDEN_TANK.get()) {/*gold*/
			max_stock = 35;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.TITANE_TANK.get()) {/*titane*/
			max_stock = 95;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.PALADIUM_TANK.get()) {/*paladium*/
			max_stock = 135;
		}
		if (PalamodModItems.FLASK.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (world instanceof ServerLevel _serverLevelGR26 && _serverLevelGR26.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
				PalamodMod.LOGGER.info((((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("seve", 0)) + " - " + seve_string));
			}
			if (0 < (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("seve", 0)) {
				PalamodMod.LOGGER.info((getBlockNBTString(world, BlockPos.containing(x, y, z), "type") + " -  block"));
				if ((seve_string).equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "type")) || ("None").equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "type"))) {
					if (max_stock >= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock")
							+ (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("seve", 0)) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock")
										+ (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("seve", 0)));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						{
							final String _tagName = "seve";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putString("type", seve_string);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("stock", max_stock);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						{
							final String _tagName = "seve";
							final double _tagValue = ((getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock")
									+ (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("seve", 0)) - max_stock);
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
				}
			} else {
				if (0 < getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock")) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock") <= 15) {
						{
							final String _tagName = "seve";
							final double _tagValue = (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock"));
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("stock", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else {
						{
							final String _tagName = "seve";
							final double _tagValue = 15;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock") - 15));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			}
		} else {
			if (entity instanceof ServerPlayer _player)
				_player.sendSystemMessage(Component.literal((BuiltInRegistries.ITEM.getKey((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())).getItem()).toString() + " - "
						+ getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock") + "/" + max_stock + " | Type : " + getBlockNBTString(world, BlockPos.containing(x, y, z), "type"))), false);
		} /*reload blockstate*/
		if (("jacaranda").equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "type"))) {
			decalc_blockstate = 0;
		} else if (("erable").equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "type"))) {
			decalc_blockstate = 7;
		} else if (("judeecercis").equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "type"))) {
			decalc_blockstate = 14;
		} else if (("ostrya").equals(getBlockNBTString(world, BlockPos.containing(x, y, z), "type"))) {
			decalc_blockstate = 21;
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock") > 0) {
			{
				int _value = (int) ((getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock") / max_stock) * 7 + decalc_blockstate);
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
		if (world instanceof ServerLevel _serverLevelGR76 && _serverLevelGR76.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
			PalamodMod.LOGGER.debug(("fin-tank V2" + "\n" + "tank" + "\n" + "stock : " + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock") + "\n" + "BLOCKSTATE : "
					+ ((getBlockNBTNumber(world, BlockPos.containing(x, y, z), "stock") / max_stock) * 7 + decalc_blockstate) + "\n" + "fin-tank"));
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}
}