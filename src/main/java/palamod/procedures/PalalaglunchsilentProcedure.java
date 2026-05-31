package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Optional;

public class PalalaglunchsilentProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level && _level.getServer() != null) {
			Optional<CommandFunction<CommandSourceStack>> _fopt = _level.getServer().getFunctions().get(ResourceLocation.parse("palamod:palalag_mob_passive"));
			if (_fopt.isPresent())
				_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null));
		}
		if (world instanceof ServerLevel _level && _level.getServer() != null) {
			Optional<CommandFunction<CommandSourceStack>> _fopt = _level.getServer().getFunctions().get(ResourceLocation.parse("palamod:palalag_item"));
			if (_fopt.isPresent())
				_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null));
		}
		if (world instanceof ServerLevel _level && _level.getServer() != null) {
			Optional<CommandFunction<CommandSourceStack>> _fopt = _level.getServer().getFunctions().get(ResourceLocation.parse("palamod:palalagmobagressive"));
			if (_fopt.isPresent())
				_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null));
		}
		if (world instanceof ServerLevel _level && _level.getServer() != null) {
			Optional<CommandFunction<CommandSourceStack>> _fopt = _level.getServer().getFunctions().get(ResourceLocation.parse("palamod:palalag_mob_player"));
			if (_fopt.isPresent())
				_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null));
		}
	}
}