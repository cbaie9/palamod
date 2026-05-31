package palamod.procedures;

import palamod.init.PalamodModItems;

import palamod.PalamodMod;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class PrintingpressprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double remove_item = 0;
		ItemStack output_item = ItemStack.EMPTY;
		PalamodMod.LOGGER.debug(("plate :" + getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isplateready")));
		PalamodMod.LOGGER.debug(("book :" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count")));
		PalamodMod.LOGGER.debug(("ink :" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count")));
		PalamodMod.LOGGER.debug(("locked :" + getBlockNBTLogic(world, BlockPos.containing(x, y, z), "locked")));
		if (entity.isShiftKeyDown()) {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isplateready") && 3 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count") && 6 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("locked", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				output_item = new ItemStack(Items.ENCHANTED_BOOK).copy();
				output_item.applyComponents((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getComponents());
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 0.25), z, output_item);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("nb_book", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_book") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "nb_book") >= 3) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("ink_count", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count") - 6));
							_blockEntity.getPersistentData().putDouble("book_count", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count") - 3));
							_blockEntity.getPersistentData().putDouble("nb_book", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
						_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean("locked", false);
							_blockEntity.getPersistentData().putBoolean("isplateready", false);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.anvil.destroy")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.anvil.destroy")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				} else {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.anvil.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.anvil.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
			}
		} else {
			if (!getBlockNBTLogic(world, BlockPos.containing(x, y, z), "locked")) {
				if (PalamodModItems.PLATE.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("enchanted", false)
							&& false == getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isplateready")) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putBoolean("isplateready", true);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						output_item = new ItemStack(PalamodModItems.PLATE.get()).copy();
						output_item.applyComponents((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getComponents());
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = output_item.copy();
							_setstack.setCount(1);
							_itemHandlerModifiable.setStackInSlot(0, _setstack);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("plate ready"), false);
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack40 = new ItemStack(Blocks.AIR).copy();
							_setstack40.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack40);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				} else if (PalamodModItems.PALADIUM_INK.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() && 64 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count")) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() <= 64 - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count")) {
						remove_item = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount();
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("ink_count",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count")));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("ink count :" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count"))), false);
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack57 = new ItemStack(PalamodModItems.PALADIUM_INK.get()).copy();
							_setstack57.setCount((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - remove_item));
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack57);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() > 64 - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count")) {
						remove_item = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - (64 - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count"));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("ink count :" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count"))), false);
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack68 = new ItemStack(PalamodModItems.PALADIUM_INK.get()).copy();
							_setstack68.setCount((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - remove_item));
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack68);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				} else if (Items.BOOK == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() && 64 > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count")) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() <= 64 - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count")) {
						remove_item = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount();
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("book_count",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count")));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("book count :" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count"))), false);
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack85 = new ItemStack(Items.WRITTEN_BOOK).copy();
							_setstack85.setCount((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - remove_item));
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack85);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() > 64 - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count")) {
						remove_item = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - (64 - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count"));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("book count :" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count"))), false);
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack96 = new ItemStack(Items.BOOK).copy();
							_setstack96.setCount((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - remove_item));
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack96);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				} else {
					if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isplateready") && !getBlockNBTLogic(world, BlockPos.containing(x, y, z), "locked")) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putBoolean("isplateready", false);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						output_item = new ItemStack(PalamodModItems.PLATE.get()).copy();
						output_item.applyComponents((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getComponents());
						if (entity instanceof Player _player) {
							ItemStack _setstack = output_item.copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
							_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
					} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count") > 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("ink_count", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count") - 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("ink count :" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ink_count"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 0.25), z, new ItemStack(PalamodModItems.PALADIUM_INK.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count") > 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("book_count", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count") - 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("book count :" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "book_count"))), false);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 0.25), z, new ItemStack(Items.BOOK));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
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

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}