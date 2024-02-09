package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class VoidstonetextconfProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (0 >= itemstack.getOrCreateTag().getDouble("cooldown")) {
			if (itemstack.getOrCreateTag().getBoolean("powered")) {
				itemstack.getOrCreateTag().putBoolean("powered", false);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @p {\"text\":\"Voidstone : Deactivated\",\"color\":\"gold\"}");
				itemstack.getOrCreateTag().putDouble("cooldown", 20);
			} else {
				itemstack.getOrCreateTag().putBoolean("powered", true);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @p {\"text\":\"Voidstone : Activated\",\"color\":\"gold\"}");
				itemstack.getOrCreateTag().putDouble("cooldown", 20);
			}
		} else if (!itemstack.getOrCreateTag().getBoolean("voidstonesetuped")) {
			itemstack.getOrCreateTag().putDouble("cooldown", 20);
			itemstack.getOrCreateTag().putBoolean("voidstonesetuped", true);
			itemstack.getOrCreateTag().putBoolean("powered", true);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"tellraw @p {\"text\":\"Voidstone : Activated\",\"color\":\"gold\"}");
		}
	}
}
