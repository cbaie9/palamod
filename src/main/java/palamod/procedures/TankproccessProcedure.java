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
			if (true) {
				if (max_stock >= ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip11
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip11)
						: -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("seve")) {
					{
						int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip15
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip15)
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
						final double _tagValue = ((((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip23
								? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip23)
								: -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("seve")) - max_stock);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
					}
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((BuiltInRegistries.ITEM.getKey((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())).getItem()).toString() + " - "
						+ ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip32 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip32) : -1)
						+ "/" + max_stock + " | Type : " + (blockstate.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep34 ? blockstate.getValue(_getep34).toString() : ""))), false);
		} /*reload blockstate*/
		if (("jacaranda").equals(blockstate.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep37 ? blockstate.getValue(_getep37).toString() : "")) {
			decalc_blockstate = 1;
		} else if (("erable").equals(blockstate.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep39 ? blockstate.getValue(_getep39).toString() : "")) {
			decalc_blockstate = 8;
		} else if (("judeecercis").equals(blockstate.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep41 ? blockstate.getValue(_getep41).toString() : "")) {
			decalc_blockstate = 15;
		} else if (("ostrya").equals(blockstate.getBlock().getStateDefinition().getProperty("type") instanceof EnumProperty _getep43 ? blockstate.getValue(_getep43).toString() : "")) {
			decalc_blockstate = 22;
		}
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip45 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip45) : -1) > 0) {
			{
				int _value = (int) ((((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("stock") instanceof IntegerProperty _getip47
						? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip47)
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