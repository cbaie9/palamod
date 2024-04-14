package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class DelfactionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		if ((new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_leader_" + (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID())))))).equals(entity.getStringUUID())) {
			entity.getPersistentData().putBoolean(("faction-warning_" + (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getStringUUID())))), true);
			random = Mth.nextInt(RandomSource.create(), 1, 10000);
			entity.getPersistentData().putDouble("faction-code", random);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" Are you sure you want to delete this faction, to confiirm yes type \",\"color\":\"gold\"},{\"text\":\"/faction disband\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/faction disband "
								+ "" + random + "\"}},{\"text\":\" \\u0020" + random + " or \",\"color\":\"gold\"},{\"text\":\"/f disband\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/f disband " + random
								+ "\"}},{\"text\":\"" + random + "\",\"color\":\"gold\"}]"));
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" You don't have the required permission to disband the faction. If you want to quit the faction type \",\"color\":\"gold\"},{\"text\":\"/faction leave\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/faction leave\"}},{\"text\":\" or \",\"color\":\"gold\"},{\"text\":\"/f leave\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/f leave\"}}]");
		}
	}
}
