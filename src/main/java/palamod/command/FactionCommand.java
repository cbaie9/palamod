
package palamod.command;

import palamod.procedures.UnclaimprocessProcedure;
import palamod.procedures.SethomefactionprocessProcedure;
import palamod.procedures.OpenfhguiProcedure;
import palamod.procedures.FinfofacProcedure;
import palamod.procedures.FactionpromoteprocessProcedure;
import palamod.procedures.FactionleaveProcedure;
import palamod.procedures.FactionjoinProcedure;
import palamod.procedures.FactioninviteprocessProcedure;
import palamod.procedures.FactionhomeprocessProcedure;
import palamod.procedures.FactionhomelistProcedure;
import palamod.procedures.FactiondemoteprocessProcedure;
import palamod.procedures.FactioncreateProcedure;
import palamod.procedures.DelfactiontrueProcedure;
import palamod.procedures.DelfactionProcedure;
import palamod.procedures.ClaimsystemProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class FactionCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		if (event.getCommandSelection() == Commands.CommandSelection.DEDICATED)
			event.getDispatcher().register(Commands.literal("faction")

					.then(Commands.literal("create").then(Commands.argument("fac_name", StringArgumentType.word()).executes(arguments -> {
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

						FactioncreateProcedure.execute(world, x, y, z, arguments, entity);
						return 0;
					}))).then(Commands.literal("gui").executes(arguments -> {
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

						OpenfhguiProcedure.execute(world, x, y, z, entity);
						return 0;
					})).then(Commands.literal("disband").executes(arguments -> {
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

						DelfactionProcedure.execute(world, x, y, z, entity);
						return 0;
					}).then(Commands.argument("code", DoubleArgumentType.doubleArg()).executes(arguments -> {
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

						DelfactiontrueProcedure.execute(world, x, y, z, arguments, entity);
						return 0;
					}))).then(Commands.literal("leave").executes(arguments -> {
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

						FactionleaveProcedure.execute(world, x, y, z, entity);
						return 0;
					})).then(Commands.literal("invite").then(Commands.argument("player", EntityArgument.players()).executes(arguments -> {
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

						FactioninviteprocessProcedure.execute(world, x, y, z, arguments, entity);
						return 0;
					}))).then(Commands.literal("join").then(Commands.argument("fac_join_name", StringArgumentType.word()).executes(arguments -> {
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

						FactionjoinProcedure.execute(world, x, y, z, arguments, entity);
						return 0;
					}))).then(Commands.literal("info").then(Commands.literal("my").executes(arguments -> {
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

						FinfofacProcedure.execute(world, x, y, z, entity);
						return 0;
					}))).then(Commands.literal("claim").executes(arguments -> {
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

						ClaimsystemProcedure.execute(world, x, y, z, entity);
						return 0;
					})).then(Commands.literal("unclaim").executes(arguments -> {
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

						UnclaimprocessProcedure.execute(world, x, y, z, entity);
						return 0;
					})).then(Commands.literal("promote").then(Commands.argument("player_promote", EntityArgument.players()).executes(arguments -> {
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

						FactionpromoteprocessProcedure.execute(world, x, y, z, arguments, entity);
						return 0;
					}))).then(Commands.literal("demote").then(Commands.argument("player_demote", EntityArgument.player()).executes(arguments -> {
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

						FactiondemoteprocessProcedure.execute(world, x, y, z, arguments, entity);
						return 0;
					}))).then(Commands.literal("sethome").then(Commands.argument("home_name", StringArgumentType.word()).executes(arguments -> {
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

						SethomefactionprocessProcedure.execute(world, x, y, z, arguments, entity);
						return 0;
					}))).then(Commands.literal("home").then(Commands.argument("home_name", StringArgumentType.word()).executes(arguments -> {
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

						FactionhomeprocessProcedure.execute(world, x, y, z, arguments, entity);
						return 0;
					})).then(Commands.literal("list").executes(arguments -> {
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

						FactionhomelistProcedure.execute(world, x, y, z, entity);
						return 0;
					}))));
	}
}
