package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class DelfactiontrueProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double get_id = 0;
		String get_name = "";
		boolean fget_id = false;
		if (entity.getPersistentData().getBooleanOr(("faction-warning_" + getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID()))), false)) {
			if (entity.getPersistentData().getDoubleOr("faction-code", 0) == DoubleArgumentType.getDouble(arguments, "code")) {
				if ((getBlockNBTString(world, new BlockPos(0, 9, 0), ("Faction_leader_" + getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID()))))).equals(entity.getStringUUID())) {
					get_id = getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID()));
					get_name = getBlockNBTString(world, new BlockPos(0, 9, 0), ("Faction_name_" + get_id));
					if (!world.isClientSide()) {
						BlockPos _bp = new BlockPos(0, 9, 0);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putBoolean(("Faction_oc_" + get_id), false);
							_blockEntity.getPersistentData().putDouble(("Faction_nb-m_" + get_id), (-1));
							_blockEntity.getPersistentData().putDouble(("Faction_nb-off_" + get_id), (-1));
							_blockEntity.getPersistentData().putDouble(("Faction_nb-co-leader_" + get_id), (-1));
							_blockEntity.getPersistentData().putDouble(("Faction_xp" + get_id), (-1));
							_blockEntity.getPersistentData().putDouble(("Faction_lv" + get_id), (-1));
							_blockEntity.getPersistentData().putString(("Faction_name_" + get_id), ("[ deleted-faction: \"" + "" + get_name + "\" ]"));
							_blockEntity.getPersistentData().putString(("Faction_leader_" + get_id), ("[ deleted-faction: \"" + "" + get_name + "\" ]"));
							_blockEntity.getPersistentData().putDouble(("Faction_id_" + get_name), ((-1) * get_id));
							_blockEntity.getPersistentData().putString(("Faction_leader_" + get_id), ("[ deleted-faction: \"" + "" + get_name + "\" ]"));
							_blockEntity.getPersistentData().putBoolean(("Faction_has_" + entity.getStringUUID()), false);
							_blockEntity.getPersistentData().putBoolean(("Faction_hbc_" + get_id), true);
							_blockEntity.getPersistentData().putDouble(("Faction_" + entity.getStringUUID()), ((-1) * get_id));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (entity instanceof ServerPlayer _player)
						_player.sendSystemMessage(Component.literal(("The faction " + get_name + "has been deleted")), false);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("tellraw @a [\"\",{\"text\":\"[ Palamod ] : \",\"color\":\"dark_red\"},{\"text\":\"The faction  " + "" + get_name + " has been disband\",\"color\":\"gold\"}]"));
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @p [\"\",{\"text\":\"[ Palamod ] : \",\"color\":\"dark_red\"},{\"text\":\"You may has been dismiss because you don't the required permission to do that command\",\"color\":\"gold\"}]");
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @p [\"\",{\"text\":\"[ Palamod ] : \",\"color\":\"dark_red\"},{\"text\":\"The code you send isn't correct, retry using the correct code\",\"color\":\"gold\"}]");
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p [\"\",{\"text\":\"[ Palamod ] : \",\"color\":\"dark_red\"},{\"text\":\"An unexpected error has been detected, retry using the /faction disband or /f disband without any arguments\",\"color\":\"gold\"}]");
		}
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