
package palamod.command;

import palamod.procedures.JobsminersetxpProcedure;
import palamod.procedures.JobsminersetlevelProcedure;
import palamod.procedures.JobsmineraddxpProcedure;
import palamod.procedures.JobsmineraddlevelsProcedure;
import palamod.procedures.JobshuntersetxpProcedure;
import palamod.procedures.JobshuntersetlevelProcedure;
import palamod.procedures.JobshunteraddxpProcedure;
import palamod.procedures.JobshunteraddlevelProcedure;
import palamod.procedures.JobsfarmersetxpProcedure;
import palamod.procedures.JobsfarmersetlevelProcedure;
import palamod.procedures.JobsfarmeraddxpProcedure;
import palamod.procedures.JobsfarmeraddlevelProcedure;
import palamod.procedures.JobsalchisetxpProcedure;
import palamod.procedures.JobsalchisetlevelProcedure;
import palamod.procedures.JobsalchiaddxpProcedure;
import palamod.procedures.JobsalchiaddlevelProcedure;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class JobscommandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("jobs").requires(s -> s.hasPermission(2))
				.then(Commands.literal("miner").then(Commands.literal("set").then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("levels").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsminersetlevelProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("xp").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsminersetxpProcedure.execute(arguments, entity);
					return 0;
				})))).then(Commands.literal("add").then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("levels").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsmineraddlevelsProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("xp").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsmineraddxpProcedure.execute(arguments, entity);
					return 0;
				}))))).then(Commands.literal("farmer").then(Commands.literal("set").then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("levels").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsfarmersetlevelProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("xp").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsfarmersetxpProcedure.execute(arguments, entity);
					return 0;
				})))).then(Commands.literal("add").then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("levels").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsfarmeraddlevelProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("xp").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsfarmeraddxpProcedure.execute(arguments, entity);
					return 0;
				}))))).then(Commands.literal("hunter").then(Commands.literal("set").then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("levels").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobshuntersetlevelProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("xp").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobshuntersetxpProcedure.execute(arguments, entity);
					return 0;
				})))).then(Commands.literal("add").then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("levels").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobshunteraddlevelProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("xp").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobshunteraddxpProcedure.execute(arguments, entity);
					return 0;
				}))))).then(Commands.literal("alchimist").then(Commands.literal("set").then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("levels").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsalchisetlevelProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("xp").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsalchisetxpProcedure.execute(arguments, entity);
					return 0;
				})))).then(Commands.literal("add").then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("levels").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsalchiaddlevelProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.argument("num", DoubleArgumentType.doubleArg()).then(Commands.literal("xp").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					JobsalchiaddxpProcedure.execute(arguments, entity);
					return 0;
				}))))));
	}
}
