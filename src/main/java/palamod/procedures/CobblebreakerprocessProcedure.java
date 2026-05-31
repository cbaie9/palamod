package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.Container;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class CobblebreakerprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack teststack = ItemStack.EMPTY;
		double coef = 0;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).copy()).getItem() == PalamodModItems.COBBLEBREAKER_PALADIUM_UPGRADE.get()) {
			coef = 4;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).copy()).getItem() == PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get()) {
			coef = 2.5;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).copy()).getItem() == PalamodModItems.COBBLEBREAKER_AMETHYST_UPGRADE.get()) {
			coef = 1.5;
		} else {
			coef = 1;
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(Identifier.parse("palamod:cobblebreakable")))
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.MINAGE_VOIDSTONE.get()
						&& 0 < (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("voidstone_count", 0)) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tick") >= 100) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.MINAGE_VOIDSTONE.get()) {
					teststack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (teststack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("voidstone_count", 0) - 1);
						CustomData.update(DataComponents.CUSTOM_DATA, teststack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					teststack.set(DataComponents.CUSTOM_NAME, Component
							.literal((Component.translatable("item.palamod.minage_voidstone").getString() + " - " + Math.round(teststack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("voidstone_count", 0)))));
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = teststack.copy();
							_setstack.setCount(1);
							_container.setItem(0, _setstack);
						}
					}
				} else {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() <= 63 && Math.random() < 0.15) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.IRON_PARTICLE.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1);
							_container.setItem(1, _setstack);
						}
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 63 && Math.random() < 0.1) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.GOLD_PARTICLE.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
							_container.setItem(2, _setstack);
						}
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() <= 63 && Math.random() < 0.05) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.DIAMOND_PARTICLE.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() + 1);
							_container.setItem(3, _setstack);
						}
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() <= 63 && Math.random() < 0.0475) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_PARTICLE.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + 1);
							_container.setItem(4, _setstack);
						}
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() <= 63 && Math.random() < 0.0375) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_PARTICLE.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() + 1);
							_container.setItem(5, _setstack);
						}
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).getCount() <= 63 && Math.random() < 0.025) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_PARTICLE.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).getCount() + 1);
							_container.setItem(6, _setstack);
						}
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).getCount() <= 63 && Math.random() < 0.005) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_PARTICLE.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).getCount() + 1);
							_container.setItem(7, _setstack);
						}
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("cobblebreak_tick", 0);
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
						_blockEntity.getPersistentData().putDouble("cobblebreak_tick", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tick") + 1 * coef));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tickbreak") >= 1) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("cobblebreak_tickbreak", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tickbreak") - 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tick") >= 1) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tickbreak") >= 50) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("cobblebreak_tick", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tick") - 1));
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
							_blockEntity.getPersistentData().putDouble("cobblebreak_tickbreak", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tickbreak") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		}
		world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), 2);
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			ResourceHandler<ItemResource> itemHandler = ext.getCapability(Capabilities.Item.BLOCK, pos, null);
			if (itemHandler != null)
				return ItemUtil.getStack(itemHandler, slot);
		}
		return ItemStack.EMPTY;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}