package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class FactionhomeprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double get_id = 0;
		get_id = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID()));
		if ((new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_home_" + get_id + "_" + StringArgumentType.getString(arguments, "home_name")))) == true) {
			{
				Entity _ent = entity;
				_ent.teleportTo((new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + get_id + "_home_" + StringArgumentType.getString(arguments, "home_name") + "_x"))), (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + get_id + "_home_" + StringArgumentType.getString(arguments, "home_name") + "_y"))), (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + get_id + "_home_" + StringArgumentType.getString(arguments, "home_name") + "_y"))));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + get_id + "_home_" + StringArgumentType.getString(arguments, "home_name") + "_x"))), (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + get_id + "_home_" + StringArgumentType.getString(arguments, "home_name") + "_y"))), (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + get_id + "_home_" + StringArgumentType.getString(arguments, "home_name") + "_y"))), _ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" You have been teleported to your faction home " + "" + StringArgumentType.getString(arguments, "home_name") + "\",\"color\":\"gold\"}]"));
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The faction home " + "" + StringArgumentType.getString(arguments, "home_name")
								+ " witch you tried to teleported doesn't exist or has been deleted\",\"color\":\"gold\"}]"));
		}
	}
}
