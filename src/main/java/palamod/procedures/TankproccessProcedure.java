package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class TankproccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double max_stock = 0;
		double decalc_blockstate = 0;
		String seve_string = "";
		if (1 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type_of_seve")) {
			seve_string = "ostrya";
		} else if (2 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type_of_seve")) {
			seve_string = "judeecercis";
		} else if (3 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type_of_seve")) {
			seve_string = "jacaranda";
		} else if (4 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type_of_seve")) {
			seve_string = "erable";
		} else {
			seve_string = "NTOSI_error";
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.AMETHYSTTANK.get()) {/*amethyst*/
			max_stock = 60;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.AMETHYSTTANK.get()) {/*gold*/
			max_stock = 35;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.AMETHYSTTANK.get()) {/*titane*/
			max_stock = 95;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.AMETHYSTTANK.get()) {/*paladium*/
			max_stock = 135;
		}
		if (PalamodModItems.FLASK.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (0 < (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("seve")) {
				if ((seve_string).equals(
						(world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep21 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep21).toString() : "")
						|| ("None").equals((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep23
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep23).toString()
								: "")) {
					if (max_stock >= ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip25
							? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip25)
							: -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("seve")) {
						{
							int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip29
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip29)
									: -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("seve"));
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						{
							final String _tagName = "seve";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							String _value = seve_string;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
								world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
						}
					} else {
						{
							int _value = (int) max_stock;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						{
							final String _tagName = "seve";
							final double _tagValue = ((((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip38
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip38)
									: -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("seve")) - max_stock);
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
				}
			} else {
				if (0 < ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip44 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip44) : -1)) {
					if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip46
							? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip46)
							: -1) <= 15) {
						{
							final String _tagName = "seve";
							final double _tagValue = ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip48
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip48)
									: -1);
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					} else {
						{
							final String _tagName = "seve";
							final double _tagValue = 15;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							int _value = ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip55
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip55)
									: -1) - 15;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((BuiltInRegistries.ITEM.getKey((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())).getItem()).toString() + " - "
						+ ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip61 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip61) : -1)
						+ "/" + max_stock + " | Type : " + (blockstate.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep63 ? blockstate.getValue(_getep63).toString() : ""))), false);
		} /*reload blockstate*/
		if (("jacaranda").equals(blockstate.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep66 ? blockstate.getValue(_getep66).toString() : "")) {
			decalc_blockstate = 1;
		} else if (("erable").equals(blockstate.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep68 ? blockstate.getValue(_getep68).toString() : "")) {
			decalc_blockstate = 8;
		} else if (("judeecercis").equals(blockstate.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep70 ? blockstate.getValue(_getep70).toString() : "")) {
			decalc_blockstate = 15;
		} else if (("ostrya").equals(blockstate.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep72 ? blockstate.getValue(_getep72).toString() : "")) {
			decalc_blockstate = 22;
		}
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip74 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip74) : -1) > 0) {
			{
				int _value = (int) ((((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip76
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip76)
						: -1) / max_stock) * 7 + decalc_blockstate);
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
	}
}