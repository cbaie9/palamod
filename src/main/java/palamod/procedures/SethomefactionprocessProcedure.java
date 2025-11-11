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

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class SethomefactionprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double get_id = 0;
		get_id = getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID()));
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(0, 9, 0);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble(("Faction_" + get_id + "number_home"), (getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_" + get_id + "number_home")) + 1));
				_blockEntity.getPersistentData().putDouble(("Faction_" + get_id + "_home_" + StringArgumentType.getString(arguments, "home_name") + "_x"), x);
				_blockEntity.getPersistentData().putDouble(("Faction_" + get_id + "_home_" + StringArgumentType.getString(arguments, "home_name") + "_y"), y);
				_blockEntity.getPersistentData().putDouble(("Faction_" + get_id + "_home_" + StringArgumentType.getString(arguments, "home_name") + "_z"), z);
				_blockEntity.getPersistentData().putDouble(("Faction_home_id_" + StringArgumentType.getString(arguments, "home_name")), (getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_" + get_id + "number_home"))));
				_blockEntity.getPersistentData().putBoolean(("Faction_home_" + get_id + "_" + StringArgumentType.getString(arguments, "home_name")), true);
				_blockEntity.getPersistentData().putString(("Faction_home_name_" + getBlockNBTNumber(world, new BlockPos(0, 9, 0), ("Faction_" + get_id + "number_home"))), (StringArgumentType.getString(arguments, "home_name")));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" The faction home " + "" + StringArgumentType.getString(arguments, "home_name")
							+ " has been created at your position\",\"color\":\"gold\"},{\"text\":\"\\n \"}]"));
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}