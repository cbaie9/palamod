package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class FactionhomelistProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double cycle_loop = 0;
		double get_id = 0;
		get_id = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID()));
		cycle_loop = cycle_loop + 1;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"-------------------------------\",\"color\":\"dark_green\"},{\"text\":\"\\n\\n \"}]");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" Home list\",\"color\":\"dark_green\"},{\"text\":\"\\n\"},{\"text\":\"" + "" + Math.round(new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + get_id + "number_home"))) + "\",\"color\":\"dark_green\"},{\"text\":\" were home found\",\"color\":\"aqua\"},{\"text\":\"\\n \"}]"));
		for (int index0 = 0; index0 < (int) entity.getPersistentData().getDouble("number_home"); index0++) {
			if (("Faction_home_name_" + (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + cycle_loop + "number_home")))).equals("[deleted_home_open]") || ("Faction_home_name_" + (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + cycle_loop + "number_home")))).equals("[deleted_home_request]")) {
				cycle_loop = cycle_loop + 1;
				continue;
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [\"\",{\"text\":\"Home n\u00B0" + "" + Math.round(cycle_loop) + " - \",\"color\":\"aqua\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/home "
								+ entity.getPersistentData().getString(("home_name_" + cycle_loop)) + "\"}},{\"text\":\"" + ("Faction_home_name_" + (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + cycle_loop + "number_home")))) + "\",\"color\":\"dark_green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/home "
								+ ("Faction_home_name_" + (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + cycle_loop + "number_home")))) + "\"}}]"));
			cycle_loop = cycle_loop + 1;
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p [\"\",{\"text\":\"-------------------------------\",\"color\":\"dark_green\"},{\"text\":\"\\n\\n \"}]");
	}
}
