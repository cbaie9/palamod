package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.Container;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;

public class UploaderprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double num = 0;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(Identifier.parse("forge:uploadersellable")))) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()) {
				num = 120;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_INGOT.get()) {
				num = 100;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AMETHYST_INGOT.get()) {
				num = 70;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.DIAMOND) {
				num = 40;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.COAL || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.CHARCOAL) {
				num = 3;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.GOLD_INGOT) {
				num = 30;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.IRON_INGOT) {
				num = 15;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.FINDIUM.get()) {
				num = 85;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.DIRT.asItem() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.NETHERRACK.asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.STONE.asItem()) {
				num = 0.1;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.GRASS_BLOCK.asItem()) {
				num = 0.3;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.SAND.asItem()) {
				num = 0.4;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.GRAVEL.asItem()) {
				num = 0.2;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.SOUL_SAND.asItem() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.OAK_LOG.asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.CARROT || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.SPIDER_EYE
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.SOUL_SOIL.asItem()) {
				num = 0.5;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.BLACKSTONE.asItem()) {
				num = 1;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.GLOWSTONE.asItem() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.COOKED_BEEF) {
				num = 5;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.CACTUS.asItem() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.WARPED_FUNGUS.asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.CRIMSON_FUNGUS.asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.RED_MUSHROOM.asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.BROWN_MUSHROOM.asItem()) {
				num = 1;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.POTATO) {
				num = 0.75;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.SLIME_BALL) {
				num = 6;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.MELON_SLICE) {
				num = 0.8;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.WHEAT.asItem()) {
				num = 0.1;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.SUGAR_CANE.asItem()) {
				num = 4;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.ENDER_PEARL) {
				num = 5.5;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.EGG) {
				num = 3;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.STRING) {
				num = 2.25;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.BONE) {
				num = 6.75;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.FERMENTED_SPIDER_EYE && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.INK_SAC) {
				num = 5.75;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.GHAST_TEAR) {
				num = 20;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.WITHER_SKELETON_SKULL.asItem()) {
				num = 1000;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.GUNPOWDER) {
				num = 1.75;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.BLAZE_ROD) {
				num = 8.5;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.FEATHER) {
				num = 6.5;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.GLOW_INK_SAC) {
				num = 6;
			} else {
				num = 0;
			}
			if (num > 0) {
				if (world instanceof ServerLevel _serverLevel) {
					BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
					if (_be instanceof Container _container) {
						_container.getItem(0).shrink(1);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("Stocked_money", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Stocked_money") + num));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Stocked_money") > 1000 && 64 > itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount()) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.MONEY_1K.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + 1);
							_container.setItem(1, _setstack);
						}
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("Stocked_money", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Stocked_money") - 1000));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		}
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