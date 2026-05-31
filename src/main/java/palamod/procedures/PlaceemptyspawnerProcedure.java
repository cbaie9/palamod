package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class PlaceemptyspawnerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack item = ItemStack.EMPTY;
		if (PalamodModItems.EMPTY_SPAWNER_ITEM.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			item = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack3 = new ItemStack(PalamodModItems.CUSTOM_AIR.get()).copy();
				_setstack3.setCount(0);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack3);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		} else if (PalamodModItems.EMPTY_SPAWNER_ITEM.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
			item = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy();
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack7 = new ItemStack(PalamodModItems.CUSTOM_AIR.get()).copy();
				_setstack7.setCount(0);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack7);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(Identifier.parse("minecraft:replaceable")))) {
			world.setBlock(BlockPos.containing(x, y, z), PalamodModBlocks.EMPTY_SPAWNER.get().defaultBlockState(), 3);
		} else {
			world.setBlock(BlockPos.containing(x, y + 1, z), PalamodModBlocks.EMPTY_SPAWNER.get().defaultBlockState(), 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y + 1, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("soul", (item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("soul", 0)));
				_blockEntity.getPersistentData().putString("spawner_type", (item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("spawner_type", "")));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.stone.place")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
	}
}