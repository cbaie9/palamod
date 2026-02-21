package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.neoforged.neoforge.event.CommandEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import palamod.procedures.JobCraftRestrictionManagerProcedure;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ReloadcommandaddonProcedure {
	@SubscribeEvent
	public static void onCommand(CommandEvent event) {
		Entity entity = event.getParseResults().getContext().getSource().getEntity();
		if (entity != null) {
			execute(event, entity.level(), entity.getX(), entity.getY(), entity.getZ(), event.getParseResults().getReader().getString());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, String command) {
		execute(null, world, x, y, z, command);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, String command) {
		if (command == null)
			return;
		if (command.startsWith("reload") && !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.DISABLEJOBSGAMERULE)) {
			JobCraftRestrictionManagerProcedure.reload();
			MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.procedure.reload_craft_config").getString());
		}
	}
}