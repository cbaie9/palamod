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
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class Gcodev6Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double input_g1 = 0;
		double g_num_max = 0;
		double g_num = 0;
		double input_mode_grinder = 0;
		double input_g2 = 0;
		double num_enchant = 0;
		ItemStack output_craft = ItemStack.EMPTY;
		ItemStack output_fusion = ItemStack.EMPTY;
		boolean pass_mode = false;
		boolean stack_num = false;
		input_g1 = GrinderresultinputnumProcedure.execute(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy());
		input_mode_grinder = GrinderresultinputmodeProcedure.execute(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy());
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") == input_mode_grinder || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") == 4) {
			pass_mode = true;
		} else {
			pass_mode = false;
		}
		g_num_max = 100;
		g_num = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum");
		if (input_g1 > 0 && input_g1 + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") <= g_num_max && pass_mode) {
			if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "llic_input")).equals((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getDisplayName().getString())) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("timer_input", 1);
						_blockEntity.getPersistentData().putString("llic_input", ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getDisplayName().getString()));
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
						_blockEntity.getPersistentData().putDouble("timer_input", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_input") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_input") >= 10) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("gnum", (input_g1 + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")));
						_blockEntity.getPersistentData().putDouble("timer_input", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 3;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") == 4) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("g_ingot", input_mode_grinder);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		}
		input_g2 = GrinderresultcraftnumProcedure.execute(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy(), itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy(),
				getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum"));
		if (input_g2 > 0) {
			output_craft = GrinderresultcraftresultProcedure.execute(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy(), itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy(),
					getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum"), getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot")).copy();
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0
					|| input_g2 + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 64 && output_craft.getItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()
							&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getMaxStackSize()
							&& !output_craft.is(ItemTags.create(ResourceLocation.parse("palamod:heads")))) {
				if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "llic_craft")).equals(output_craft.getDisplayName().getString())) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer_craft", 1);
							_blockEntity.getPersistentData().putString("llic_craft", (output_craft.getDisplayName().getString()));
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
							_blockEntity.getPersistentData().putDouble("timer_craft", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_craft") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_craft") >= 40) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("gnum", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum")
									- GrinderresultcraftgnumProcedure.execute(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy(), itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy())));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = output_craft.copy();
						_setstack.setCount((int) (input_g2 + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount()));
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
					if (!(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("palamod:grinder_craft_noclear")))) {
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 0;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
					}
					if (!(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("palamod:grinder_craft_noclear")))) {
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 1;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer_craft", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "g_ingot") != 4 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "gnum") == 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("g_ingot", 4);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).is(ItemTags.create(ResourceLocation.parse("palamod:hammer_grinder")))
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).is(ItemTags.create(ResourceLocation.parse("palamod:upgrades_grinder")))) {
			num_enchant = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))))
					+ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))))
					+ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt"))));
			if (num_enchant < 3 + (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:onemoreupgradeenchant"))))) {
				if (PalamodModItems.SPEED_MODIFIER.get() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() && (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed")))) != 0)
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
								.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed")))) < 3)) {
					if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "llic_fusion")).equals(new ItemStack(PalamodModItems.SPEED_MODIFIER.get()).getDisplayName().getString())) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("timer_fusion", 1);
								_blockEntity.getPersistentData().putString("llic_fusion", (new ItemStack(PalamodModItems.SPEED_MODIFIER.get()).getDisplayName().getString()));
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
								_blockEntity.getPersistentData().putDouble("timer_fusion", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion") + 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (40 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion")) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("timer_fusion", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						output_fusion = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
						output_fusion.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY),
								output_fusion.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed")))) + 1);
						{
							final String _tagName = "modifier";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, output_fusion, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						output_fusion.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))),
								output_fusion.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed")))) + 1);
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 4;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = output_fusion.copy();
							_setstack.setCount(1);
							_itemHandlerModifiable.setStackInSlot(5, _setstack);
						}
					}
				} else if (PalamodModItems.FORTUNE_MODIFIER.get() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() && (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune")))) != 0)
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
								.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune")))) < 3)) {
					if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "llic_fusion")).equals(new ItemStack(PalamodModItems.FORTUNE_MODIFIER.get()).getDisplayName().getString())) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("timer_fusion", 1);
								_blockEntity.getPersistentData().putString("llic_fusion", (new ItemStack(PalamodModItems.FORTUNE_MODIFIER.get()).getDisplayName().getString()));
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
								_blockEntity.getPersistentData().putDouble("timer_fusion", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion") + 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (10 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion")) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("timer_fusion", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						output_fusion = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
						{
							final String _tagName = "modifier";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, output_fusion, tag -> tag.putBoolean(_tagName, _tagValue));
						}
						output_fusion.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))),
								output_fusion.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune")))) + 1);
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 4;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = output_fusion.copy();
							_setstack.setCount(1);
							_itemHandlerModifiable.setStackInSlot(5, _setstack);
						}
					}
				} else if (PalamodModItems.SMELT_MODIFIER.get() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() && !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt")))) != 0)) {
					if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "llic_fusion")).equals(new ItemStack(PalamodModItems.SMELT_MODIFIER.get()).getDisplayName().getString())) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("timer_fusion", 1);
								_blockEntity.getPersistentData().putString("llic_fusion", (new ItemStack(PalamodModItems.SMELT_MODIFIER.get()).getDisplayName().getString()));
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
								_blockEntity.getPersistentData().putDouble("timer_fusion", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion") + 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (10 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion")) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("timer_fusion", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						output_fusion = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
						output_fusion.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt"))), 1);
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 4;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = output_fusion.copy();
							_setstack.setCount(1);
							_itemHandlerModifiable.setStackInSlot(5, _setstack);
						}
					}
				}
			} else if (PalamodModItems.ONE_MORE_MODIFIER.get() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() && (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:onemoreupgradeenchant")))) != 0)
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:onemoreupgradeenchant")))) < 2)) {
				if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "llic_fusion")).equals(new ItemStack(PalamodModItems.ONE_MORE_MODIFIER.get()).getDisplayName().getString())) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer_fusion", 1);
							_blockEntity.getPersistentData().putString("llic_fusion", (new ItemStack(PalamodModItems.ONE_MORE_MODIFIER.get()).getDisplayName().getString()));
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
							_blockEntity.getPersistentData().putDouble("timer_fusion", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (10 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion")) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer_fusion", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					output_fusion = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
					{
						final String _tagName = "modifier";
						final boolean _tagValue = true;
						CustomData.update(DataComponents.CUSTOM_DATA, output_fusion, tag -> tag.putBoolean(_tagName, _tagValue));
					}
					output_fusion.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:onemoreupgradeenchant"))),
							output_fusion.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:onemoreupgradeenchant")))) + 1);
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 4;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = output_fusion.copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(5, _setstack);
					}
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).is(ItemTags.create(ResourceLocation.parse("palamod:potg_can_be_enchanted")))) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.AUTO_SMELT_UPGRADE_POTG.get() && !((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0)) {
				if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "llic_fusion")).equals(new ItemStack(PalamodModItems.AUTO_SMELT_UPGRADE_POTG.get()).getDisplayName().getString())) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer_fusion", 1);
							_blockEntity.getPersistentData().putString("llic_fusion", (new ItemStack(PalamodModItems.AUTO_SMELT_UPGRADE_POTG.get()).getDisplayName().getString()));
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
							_blockEntity.getPersistentData().putDouble("timer_fusion", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (10 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion")) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer_fusion", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					output_fusion = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
					{
						final String _tagName = "modifier";
						final boolean _tagValue = true;
						CustomData.update(DataComponents.CUSTOM_DATA, output_fusion, tag -> tag.putBoolean(_tagName, _tagValue));
					}
					output_fusion.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))),
							output_fusion.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) + 1);
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 4;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = output_fusion.copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(5, _setstack);
					}
				}
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.BIG_HOLE_UPGRADE.get() && (!((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0)
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0
							&& 1 == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy())
									.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))))) {
				if (!(getBlockNBTString(world, BlockPos.containing(x, y, z), "llic_fusion")).equals(new ItemStack(PalamodModItems.BIG_HOLE_UPGRADE.get()).getDisplayName().getString())) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer_fusion", 1);
							_blockEntity.getPersistentData().putString("llic_fusion", (new ItemStack(PalamodModItems.BIG_HOLE_UPGRADE.get()).getDisplayName().getString()));
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
							_blockEntity.getPersistentData().putDouble("timer_fusion", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (10 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer_fusion")) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer_fusion", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					output_fusion = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).copy();
					{
						final String _tagName = "modifier";
						final boolean _tagValue = true;
						CustomData.update(DataComponents.CUSTOM_DATA, output_fusion, tag -> tag.putBoolean(_tagName, _tagValue));
					}
					output_fusion.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))),
							output_fusion.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) + 1);
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 4;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = output_fusion.copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(5, _setstack);
					}
				}
			}
		}
		world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), 1);
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
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
	}
}