package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class TankItemPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		BlockState tank = Blocks.AIR.defaultBlockState();
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("tank_type", 0) == 1) {
			tank = PalamodModBlocks.GOLDEN_TANK.get().defaultBlockState();
		} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("tank_type", 0) == 2) {
			tank = PalamodModBlocks.AMETHYST_TANK.get().defaultBlockState();
		} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("tank_type", 0) == 3) {
			tank = PalamodModBlocks.TITANE_TANK.get().defaultBlockState();
		} else {
			tank = PalamodModBlocks.PALADIUM_TANK.get().defaultBlockState();
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable"))) || Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			world.setBlock(BlockPos.containing(x, y, z), tank, 3);
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("setup", true);
					_blockEntity.getPersistentData().putDouble("stock", (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("stock", 0)));
					_blockEntity.getPersistentData().putString("type", (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("type", "")));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack18 = new ItemStack(Blocks.AIR).copy();
				_setstack18.setCount(0);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack18);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		} else {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:replaceable"))) || Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), tank, 3);
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y + 1, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("setup", true);
						_blockEntity.getPersistentData().putDouble("stock", (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("stock", 0)));
						_blockEntity.getPersistentData().putString("type", (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("type", "")));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack31 = new ItemStack(Blocks.AIR).copy();
					_setstack31.setCount(0);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack31);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("palamod.item.tank_item.place").getString())), false);
			}
		}
	}
}