package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
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
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("palamod:cobblebreakable")))
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.MINAGE_VOIDSTONE.get()
						&& 0 < (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count")) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tick") >= 100) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.MINAGE_VOIDSTONE.get()) {
					teststack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (teststack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") - 1);
						CustomData.update(DataComponents.CUSTOM_DATA, teststack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					teststack.set(DataComponents.CUSTOM_NAME,
							Component.literal((Component.translatable("item.palamod.minage_voidstone").getString() + " - " + Math.round(teststack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count")))));
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = teststack.copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(0, _setstack);
					}
				} else {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 0;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() <= 63 && Math.random() < 0.15) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.IRON_PARTICLE.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(1, _setstack);
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 63 && Math.random() < 0.1) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.GOLD_PARTICLE.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() <= 63 && Math.random() < 0.05) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.DIAMOND_PARTICLE.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(3, _setstack);
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() <= 63 && Math.random() < 0.0475) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_PARTICLE.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(4, _setstack);
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() <= 63 && Math.random() < 0.0375) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_PARTICLE.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(5, _setstack);
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).getCount() <= 63 && Math.random() < 0.025) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_PARTICLE.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(6, _setstack);
					}
				}
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).getCount() <= 63 && Math.random() < 0.005) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_PARTICLE.get()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(7, _setstack);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("cobblebreak_tick", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("cobblebreak_tick", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tick") + 1 * coef));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tickbreak") >= 1) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("cobblebreak_tickbreak", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tickbreak") - 1));
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
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("cobblebreak_tick", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tick") - 1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("cobblebreak_tickbreak", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cobblebreak_tickbreak") + 1));
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
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}