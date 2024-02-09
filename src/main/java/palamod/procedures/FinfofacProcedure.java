package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class FinfofacProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double get_id = 0;
		String get_name = "";
		get_id = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getUUID().toString()));
		get_name = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_name_" + (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 9, 0), ("Faction_" + entity.getUUID().toString())))));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\"\\n\"},{\"text\":\"---------------------------------------\",\"color\":\"dark_green\"},{\"text\":\"\\n\"},{\"text\":\"Faction \",\"color\":\"aqua\"},{\"text\":\""
							+ "" + get_name + "\",\"color\":\"gold\"},{\"text\":\"\\n\\n\"},{\"text\":\"Leader (uuid) : \",\"color\":\"aqua\"},{\"text\":\"" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos(0, 9, 0), ("Faction_leader_" + get_id)))
							+ "\",\"color\":\"gold\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"The leader of the faction\"}},{\"text\":\"\\n\"},{\"text\":\"Member in the faction : \",\"color\":\"aqua\"},{\"text\":\""
							+ Math.round(new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(0, 9, 0), ("Faction_nb-m_" + get_id)))
							+ "\",\"color\":\"gold\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"The total of member who are actually in the faction\"}},{\"text\":\"\\n\"},{\"text\":\"Power : \",\"color\":\"aqua\"},{\"text\":\""
							+ Math.round(new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(0, 9, 0), ("Faction_power_" + get_id)))
							+ "\",\"color\":\"gold\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"It's a number who determine if you can surclaim someone territory. It's increases when, you have large amount of member in the faction and decrease when you die ( it regenerate when you say alive of a certain period of time )\"}},{\"text\":\"\\n\"},{\"text\":\"Invitation in circulation : \",\"color\":\"aqua\"},{\"text\":\""
							+ Math.round(new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(0, 9, 0), ("Faction_invite_" + get_id)))
							+ "\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/faction invite\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"Number of player who were invited in the faction\"}},{\"text\":\"\\n\"},{\"text\":\"Number of officer : \",\"color\":\"aqua\"},{\"text\":\""
							+ Math.round(new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(0, 9, 0), ("Faction_nb-offi_" + get_id)))
							+ "\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/faction promote\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"Number of officer in the faction\"}},{\"text\":\"\\n\\n\"},{\"text\":\"-> Type \",\"color\":\"gold\"},{\"keybind\":\"key.palamod.factionblinding\",\"color\":\"gold\"},{\"text\":\" to open the faction menu\",\"color\":\"gold\"},{\"text\":\"\\n\"},{\"text\":\"--------------------------------------\",\"color\":\"dark_green\"}]"));
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + get_id)), false);
	}
}
