package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class UnclaimprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String get_name = "";
		double get_id = 0;
		double get_power = 0;
		double ennemy_id = 0;
		double ennemy_power = 0;
		boolean can_claim = false;
		get_id = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID()));
		get_power = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_power_" + get_id));
		get_name = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_name_" + get_id));
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_has_" + entity.getStringUUID()))) {
			if (new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 9, 0), ("Faction_officer_" + entity.getStringUUID() + "_" + get_id))) {
				if (new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, new BlockPos(0, 9, 0), ("Faction_claim_" + Math.floor(x / 16) + "_" + Math.floor(z / 16)))) {
					if (get_id == new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(0, 9, 0), ("Faction_posclaim_" + Math.floor(x / 16) + "_" + Math.floor(z / 16)))) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(0, 9, 0);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble(("Faction_posclaim_" + Math.floor(x / 16) + "_" + Math.floor(z / 16)), (-1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(0, 9, 0);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean(("Faction_claim_" + Math.floor(x / 16) + "_" + Math.floor(z / 16)), false);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(0, 9, 0);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble(("Faction_ownclaim_" + get_id), ((new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, new BlockPos(0, 9, 0), ("Faction_ownclaim_" + get_id))) - 1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The chunk has been sucessfuly unclaim\",\"color\":\"gold\"}]");
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The claim where are you can't be unclaim because your faction doesn't own it\",\"color\":\"gold\"}]");
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" You aren't in a claim\",\"color\":\"gold\"}]");
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" You don't the permission to do that\",\"color\":\"gold\"}]");
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" \",\"color\":\"red\"},{\"text\":\"You don't have a faction, you can't unclaim if you don't have one\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/faction create\"}}]");
		}
	}
}
