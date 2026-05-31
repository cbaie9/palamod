package palamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class OxlibflaskluncherviaerableProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		OxLibflaskgeneratorProcedure.execute(entity, DoubleArgumentType.getDouble(arguments, "stock"), "erable");
	}
}