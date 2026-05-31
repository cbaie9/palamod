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

public class ClaimsystemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String get_name = "";
		double get_id = 0;
		double get_power = 0;
		double ennemy_id = 0;
		double ennemy_power = 0;
		boolean can_claim = false;
		get_id = getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID()));
		get_power = getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_power_" + get_id));
		get_name = getBlockNBTString(world, new BlockPos(0, 9, 0), ("Faction_name_" + get_id));
		if (getBlockNBTLogic(world, new BlockPos(0, 9, 0), ("Faction_has_" + entity.getStringUUID()))) {
			if (getBlockNBTLogic(world, new BlockPos(0, 9, 0), ("Faction_officer_" + entity.getStringUUID() + "_" + get_id))) {
				if (getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_power_" + get_id)) / 10 > getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_ownclaim_" + get_id)) - 1) {
					if (getBlockNBTLogic(world, new BlockPos(0, 9, 0), ("Faction_claim_" + Math.floor(x / 16) + "_" + Math.floor(z / 16)))) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" Chunk already claim trying to surclaim ....\",\"color\":\"gold\"}]");
						ennemy_id = getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_posclaim_" + Math.floor(x / 16) + "_" + Math.floor(z / 16)));
						ennemy_power = getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_power_" + ennemy_id));
						if (get_power > ennemy_power) {
							can_claim = true;
						} else {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" You don't have enough power to surclaim that chunk\",\"color\":\"gold\"}]");
							can_claim = false;
						}
					} else {
						can_claim = true;
					}
					if (can_claim) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(0, 9, 0);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble(("Faction_posclaim_" + Math.floor(x / 16) + "_" + Math.floor(z / 16)), get_id);
								_blockEntity.getPersistentData().putBoolean(("Faction_claim_" + Math.floor(x / 16) + "_" + Math.floor(z / 16)), true);
								_blockEntity.getPersistentData().putDouble(("Faction_ownclaim_" + get_id), (getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_ownclaim_" + get_id)) + 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The chunk has been sucessfuly claim\",\"color\":\"gold\"}]");
					}
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" You don't the permission to do that\",\"color\":\"gold\"}]");
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" \",\"color\":\"red\"},{\"text\":\"You don't have a faction, you can't claim if you have one\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/faction create\"}}]");
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

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}
}