package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class TotemclickprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double MaxItem = 0;
		double removeitem = 0;
		MaxItem = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount();
		if (PalamodModItems.PALADIUM_INGOT.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() && 64 > new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "totem_stock")) {
			if (MaxItem + new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "totem_stock") > 64) {
				removeitem = 64 - (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "totem_stock"));
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
					_setstack.setCount((int) (MaxItem - removeitem));
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("totem_stock", (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "totem_stock") + removeitem));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
					_setstack.setCount(0);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("totem_stock", (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "totem_stock") + MaxItem));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else if (entity.isShiftKeyDown()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack.setCount((int) (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "totem_stock")));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("totem_stock", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [\"\",{\"text\":\"[ \",\"color\":\"dark_red\"},{\"text\":\"Totem\",\"color\":\"gold\"},{\"text\":\" ]\",\"color\":\"dark_red\"},{\"text\":\" : " + "" + Math.round(new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "totem_stock")) + "/64\",\"color\":\"green\"},{\"text\":\"\"}]"));
		}
	}
}
