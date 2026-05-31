package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class ForgeprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean palavert_ramdom = false;
		double previousRecipe = 0;
		palavert_ramdom = false;
		previousRecipe = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe");
		if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.AMETHYST_ORE.get().asItem()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.DEEPSLATE_AMETHYST_ORE.get().asItem())
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.AMETHYST_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR10 && _serverLevelGR10.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn amethyste ore"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AMETHYST_SWORD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.AMETHYST_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR19 && _serverLevelGR19.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn amethyst broadsword"));
			}
		} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.TITANE_ORE.get().asItem()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.DEEPSLATE_TITANE_ORE.get().asItem())
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 2);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR30 && _serverLevelGR30.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane ore"));
			}
		} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.PALADIUM_ORE.get().asItem()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.DEEPSLATE_PALADIUM_ORE.get().asItem())
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 3);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR41 && _serverLevelGR41.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn paladium ore"));
			}
		} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.FINDIUM_ORE.get().asItem()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.DEEPSLATE_FINDIUM_ORE.get().asItem())
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.FINDIUM.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 4);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR52 && _serverLevelGR52.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn findium ore"));
			}
		} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.DEEPSLATE_GREEN_PALADIUM_ORE.get().asItem()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_ORE.get().asItem())
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 5);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR63 && _serverLevelGR63.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn green paladium ore"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AMETHYST_AXE.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.AMETHYST_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 61
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 6);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR72 && _serverLevelGR72.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn amethyst axe"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AMETHYST_SHOVEL.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.AMETHYST_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 63
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 7);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR81 && _serverLevelGR81.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn amethyst shovel"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AMETHYST_BROADSWORD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.AMETHYST_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 60
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 8);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR90 && _serverLevelGR90.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn amethyst broadsword"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AMETHYST_FASTSWORD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.AMETHYST_STICK.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 9);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR99 && _serverLevelGR99.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn amethyst fastsword"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AMETHYST_HAMMER.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.AMETHYST_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 58
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 10);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR108 && _serverLevelGR108.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn amethyst hammer"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AMETHYST_STICK.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.AMETHYST_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 11);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR117 && _serverLevelGR117.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn amethyst stick"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_HAMMER.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 58
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 12);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR126 && _serverLevelGR126.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane hammer"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.PALADIUM_HAMMER.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 58
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 13);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR135 && _serverLevelGR135.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn paladium hammer"));
			}
		} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_PICKAXE.get()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_AXE.get())
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 61
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 14);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR146 && _serverLevelGR146.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane pickaxe / axe"));
			}
		} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_SWORD.get()
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_STICK.get())
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 15);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR157 && _serverLevelGR157.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane stick / sword"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_SHOVEL.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 16);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR166 && _serverLevelGR166.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane shovel"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANEBROADSWORD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 60
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 17);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR175 && _serverLevelGR175.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane broadsword"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_FASTSWORD.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_STICK.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 62
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 18);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR184 && _serverLevelGR184.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane fastsword"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.TITANE_BLOCK.get().asItem()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 55
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 19);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR193 && _serverLevelGR193.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane block"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.TITANE_SLAB.get().asItem()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 61
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 20);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR202 && _serverLevelGR202.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane slab"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.TITANE_STAIRS.get().asItem()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 58
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 21);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane stairs"));
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_ARMOR_HELMET.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 58
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 22);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR219 && _serverLevelGR219.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane helmet"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_ARMOR_CHESTPLATE.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 56
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 23);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR228 && _serverLevelGR228.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane chesplate"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_ARMOR_LEGGINGS.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 57
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 24);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR237 && _serverLevelGR237.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane leggins"));
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_ARMOR_BOOTS.get()
				&& ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() <= 60
						|| itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", 25);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _serverLevelGR246 && _serverLevelGR246.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
				PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "want burn titane boots"));
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("recipe", (-1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (previousRecipe != getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("timer", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") >= 0) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") >= 100) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 0) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 2);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 1) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 2);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 2) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 2);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 3) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 2);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 4) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.FINDIUM.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 2);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 5) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (Math.random() < 0.5) {
						if (world instanceof ServerLevel _serverLevel) {
							BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
							if (_be instanceof Container _container) {
								ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_INGOT.get()).copy();
								_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 2);
								_container.setItem(2, _setstack);
							}
						}
						palavert_ramdom = true;
					}
					if (palavert_ramdom == false) {
						if (world instanceof ServerLevel _serverLevel) {
							BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
							if (_be instanceof Container _container) {
								ItemStack _setstack = new ItemStack(PalamodModItems.GREEN_PALADIUM_INGOT.get()).copy();
								_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
								_container.setItem(2, _setstack);
							}
						}
					}
					palavert_ramdom = false;
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 6) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.FINDIUM.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 3);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 7) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 8) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 4);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 9) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_STICK.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 2);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 10) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 6);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 11) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 2);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 12) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 6);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 13) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 6);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 14) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 3);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 15) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 2);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 16) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 1);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 17) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_STICK.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 2);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 18) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 9);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 19) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 3);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 20) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 6);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 21) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 5);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 22) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 8);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 23) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 7);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 24) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 4);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 25) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
							_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + 4);
							_container.setItem(2, _setstack);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 26) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 26) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
				} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") == 27) {
					if (world instanceof ServerLevel _serverLevel) {
						BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
						if (_be instanceof Container _container) {
							_container.getItem(0).shrink(1);
						}
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("timer", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") == 0) {
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() > 0 && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() != 0) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.COAL_BLOCK.asItem()) {
						if (world instanceof ServerLevel _serverLevel) {
							BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
							if (_be instanceof Container _container) {
								_container.getItem(1).shrink(1);
							}
						}
						if (world instanceof ServerLevel _serverLevelGR372 && _serverLevelGR372.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
							PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "insert block of coal"));
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("fuel", 1280);
								_blockEntity.getPersistentData().putDouble("maxFuel", 1280);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.COAL || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.CHARCOAL) {
						if (world instanceof ServerLevel _serverLevel) {
							BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
							if (_be instanceof Container _container) {
								_container.getItem(1).shrink(1);
							}
						}
						if (world instanceof ServerLevel _serverLevelGR381 && _serverLevelGR381.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
							PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "insert coal"));
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("fuel", 200);
								_blockEntity.getPersistentData().putDouble("maxFuel", 200);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_MIXED_CHARCOAL.get()) {
						if (world instanceof ServerLevel _serverLevel) {
							BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
							if (_be instanceof Container _container) {
								_container.getItem(1).shrink(1);
							}
						}
						if (world instanceof ServerLevel _serverLevelGR388 && _serverLevelGR388.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
							PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "insert palamixed coal"));
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("fuel", 2000);
								_blockEntity.getPersistentData().putDouble("maxFuel", 2000);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.GOLD_MIXEDCOAL.get()) {
						if (world instanceof ServerLevel _serverLevel) {
							BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
							if (_be instanceof Container _container) {
								_container.getItem(1).shrink(1);
							}
						}
						if (world instanceof ServerLevel _serverLevelGR395 && _serverLevelGR395.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
							PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "insert gold mixed coal"));
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("fuel", 250);
								_blockEntity.getPersistentData().putDouble("maxFuel", 250);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.AMETHYST_MIXEDCOAL.get()) {
						if (world instanceof ServerLevel _serverLevel) {
							BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
							if (_be instanceof Container _container) {
								_container.getItem(1).shrink(1);
							}
						}
						if (world instanceof ServerLevel _serverLevelGR402 && _serverLevelGR402.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
							PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "insert amethyst mixed coal"));
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("fuel", 750);
								_blockEntity.getPersistentData().putDouble("maxFuel", 750);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.TITANE_MIXED_COAL.get()) {
						if (world instanceof ServerLevel _serverLevel) {
							BlockEntity _be = _serverLevel.getBlockEntity(BlockPos.containing(x, y, z));
							if (_be instanceof Container _container) {
								_container.getItem(1).shrink(1);
							}
						}
						if (world instanceof ServerLevel _serverLevelGR409 && _serverLevelGR409.getGameRules().get(PalamodModGameRules.LOGSALL.get())) {
							PalamodMod.LOGGER.debug((("x: " + x) + "" + (" y : " + y) + (" z: : " + z) + "insert titane mixed coal"));
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("fuel", 1250);
								_blockEntity.getPersistentData().putDouble("maxFuel", 1250);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("timer", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") > 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("fuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "recipe") >= 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("timer", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				for (int index0 = 0; index0 < 100; index0++) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") > 0 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") < 20) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("timer", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "timer") + 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else {
						break;
					}
				}
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("fuelRemaining", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fuel") / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "maxFuel")));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		world.scheduleTick(BlockPos.containing(x, y, z), world.getBlockState(BlockPos.containing(x, y, z)).getBlock(), 1);
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			ResourceHandler<ItemResource> itemHandler = ext.getCapability(Capabilities.Item.BLOCK, pos, null);
			if (itemHandler != null)
				return ItemUtil.getStack(itemHandler, slot);
		}
		return ItemStack.EMPTY;
	}
}